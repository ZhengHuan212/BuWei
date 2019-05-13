package com.lkkdesign.buwei;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v4.content.FileProvider;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.lkkdesign.buwei.bean.UpdateRequest;
import com.lkkdesign.buwei.bean.UpdateResponsed;
import com.lkkdesign.buwei.constants.ApiAddress;
import com.lkkdesign.buwei.constants.Constants;
import com.lkkdesign.buwei.tools.Tools;
import com.lkkdesign.buwei.update.view.CommonProgressDialog;
import com.lkkdesign.buwei.util.AppSharePreferenceMgr;
import com.lkkdesign.buwei.util.CustomToast;
import com.lkkdesign.buwei.util.MyFunc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;
import static com.lkkdesign.buwei.constants.Constants.JSON;
import static com.lkkdesign.buwei.constants.Constants.okHttpClient;
import static com.lkkdesign.buwei.constants.Constants.updateRequest;
import static com.lkkdesign.buwei.util.ParamJson.formatUrlMap;
import static com.lkkdesign.buwei.util.ParamJson.md5;

public class SettingActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener {
    private CommonProgressDialog pBar;
    Context mContext = null;
    private Intent intent = new Intent();
    private String vision;
    private String strMachineId = "";
    private MainActivityThread mainActivityThread;
    private MyloadingDialog myloadingDialog;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 从资源文件中添Preferences ，选择的值将会自动保存到SharePreferences
        addPreferencesFromResource(R.xml.preferences);
        mContext = getApplicationContext();
        myloadingDialog = new MyloadingDialog(this);
        //初始化ProgressDialog进度条
        progressDialog = progress(this);
        strMachineId = (String) AppSharePreferenceMgr.get(this, "machineId", "");
        init();
        // 获取本版本号，是否更新
        vision = Tools.getVersionByString(this);
        System.out.println("版本号：" + vision);

        String str_list_CountDown = (String) AppSharePreferenceMgr.get(this, "list_CountDown", "120");
        System.out.println("保存的数据CountDown：" + str_list_CountDown);
        Constants.intCountDwonTime = Integer.parseInt(str_list_CountDown) * 1000;
    }

    private void init() {
        final EditTextPreference serverip = (EditTextPreference) findPreference("machineId");
        SharedPreferences shp = PreferenceManager.getDefaultSharedPreferences(this);
        serverip.setSummary(shp.getString("machineId", ""));

        Preference preCheckUpdate = (Preference) findPreference("checkupdate");
        Preference preCopyright = (Preference) findPreference("copyright");
        Preference preExitapp = (Preference) findPreference("exitapp");
        Preference addGoods = (Preference) findPreference("addGoods");
        //设置Preference的点击事件监听
        addGoods.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                //当接收到Click事件之后触发
                //sendPortData_Hex(ComDoor, Constants.strOpenAllDooor);//发送打开所有柜门扫码指令
                intent.setClass(SettingActivity.this,ExhibitGoodsActivity.class);
                startActivity(intent);
                return true;
            }
        });
        preCheckUpdate.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                myloadingDialog.show();
                mainActivityThread = new MainActivityThread();
                mainActivityThread.start();
                Log.i("settingupdate","*********");
                return true;
            }
        });
        preCopyright.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                //当接收到Click事件之后触发
                CustomToast.showToast(mContext, "暂无版权信息");
                return true;
            }
        });
        preExitapp.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                //当接收到Click事件之后触发
                CustomToast.showToast(mContext, "Preference preExitapp Clicked");
                return true;
            }
        });
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (preference instanceof ListPreference) {
            ListPreference listPreference = (ListPreference) preference;//把preference这个Preference强制转化为ListPreference类型
            CharSequence[] entries = listPreference.getEntries();//获取ListPreference中的实体内容
            int index = listPreference.findIndexOfValue((String) newValue);//获取ListPreference中的实体内容的下标值
            listPreference.setSummary(entries[index]);//listPreference中的sumamry显示为当前ListPreference的实体内容中选择的
            if ("list_CountDown".equals(listPreference.getKey())) {
                System.out.println("list_CountDown\n");
                AppSharePreferenceMgr.put(this, "list_CountDown", entries[index].toString());
            } else {
                System.out.println("list_AD\n");
                AppSharePreferenceMgr.put(this, "list_AD", entries[index].toString());
            }
            Log.d("TAG2", "onPreferenceChange run " + newValue);
            Log.i("TAG0", "listPreference " + listPreference.getKey());
            Toast.makeText(mContext, entries[index].toString(), Toast.LENGTH_LONG).show();
        }
        return true;
    }

    public void doExit(View v) {
        //Toast.makeText(mContext, "点击退出按钮", Toast.LENGTH_SHORT).show();
        //System.exit(0);
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(SettingActivity.this);
        builder.setTitle("温馨提示");
        builder.setMessage("确定要退出程序？");
        builder.setNegativeButton("不了，还是留下来", null);
        builder.setPositiveButton("是的，无情的离开", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
//                KKKLApplication.getInstance().exit();
            }
        });
        builder.show();
    }

    public void doReturn(View v) {
        Intent intent = new Intent(SettingActivity.this, VideoViewActivity.class);
        startActivity(intent);
    }


    private static final int REQUEST_CODE_SETTING = 300;
    private class MainActivityThread extends Thread {
        @Override
        public void run() {
            super.run();
            Log.i(TAG, "booTest2Thread--->booUpdate");
            getUpdateState();
        }
    }

    private void getUpdateState() {

        Log.i(TAG, "myloadingDialog--->dismiss");
        Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("machineId", "" + Constants.intMachineId);
        paraMap.put("bottleRecordId", "");
        //转换成键值对
        String strFormactUrl = formatUrlMap(paraMap, true, false);
        Log.i(TAG, "strFormactUrl=" + strFormactUrl);
        String strBeforeSgin = strFormactUrl + "&key=" + Constants.strKey;
        Log.i(TAG, "strBeforeSgin=" + strBeforeSgin);
        String strSign = md5(strBeforeSgin);
        Log.i(TAG, "strSign=" + strSign);
        updateRequest.setMachineId(Constants.intMachineId);
        updateRequest.setSign(strSign);
        String strUpdateReJson = Constants.gson.toJson(updateRequest, UpdateRequest.class);
        Log.i(TAG, "strUpdate=" + strUpdateReJson);
        //创建一个RequestBody(参数1：数据类型 参数2传递的json串)
        RequestBody requestBody = RequestBody.create(JSON, strUpdateReJson);
        Request request = new Request.Builder()
                .url(ApiAddress.update)
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        try {

            Response response = call.execute();
            String strjson = response.body().string();
            Log.i(TAG, "strjson=" + strjson);
            myloadingDialog.dismiss();
            //判断请求是否成功
            UpdateResponsed updateResponsed = Constants.gson.fromJson(strjson, UpdateResponsed.class);
            final String newVersion = updateResponsed.getNewVersion();
            String apkUrl = updateResponsed.getApkUrl();
            Log.i(TAG, "apkURL=" + apkUrl);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (newVersion.compareTo(MyFunc.packageCode(SettingActivity.this) + "") > 0) {
                        android.support.v7.app.AlertDialog alertDialog1 = new android.support.v7.app.AlertDialog.Builder(SettingActivity.this)
                                .setTitle("提示")//标题
                                .setMessage("可更新。。。")//内容
                                .setIcon(R.mipmap.ic_launcher)//图标
                                .setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        /**
                                         * 下载APK
                                         */
                                        progressDialog.show();//将ProgessDialog显示出来
                                        download(apkUrl);//开始下载

                                    }
                                })
                                .setNegativeButton("以后再说", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                })
                                .create();
                        alertDialog1.show();
                        mainActivityThread.interrupt();
                        Log.i(TAG, " mainActivityThread.interrupt();");
                    } else {
                        android.support.v7.app.AlertDialog alertDialog1 = new android.support.v7.app.AlertDialog.Builder(SettingActivity.this)
                                .setTitle("提示")//标题
                                .setMessage("当前是最新版本！")//内容
                                .setIcon(R.mipmap.ic_launcher)//图标
                                .create();
                        alertDialog1.show();
                        mainActivityThread.interrupt();
                        Log.i(TAG, " mainActivityThread.interrupt()");
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * 方法名：progress()
     * 功    能：初始化ProgressDialog进度框
     * 参    数：无
     * 返回值：ProgressDialog
     */
    private ProgressDialog progress(Context context) {
        //自定义标题
        TextView title = new TextView(context);
        title.setText("正在更新");//设置文本
        title.setPadding(0, 40, 0, 0); //边距,左上右下
        title.setGravity(Gravity.CENTER); //位置
        title.setTextColor(Color.parseColor("#5d9eff"));//字体的颜色
        title.setTextSize(23); //字体的大小
        ProgressDialog progressDialog = new ProgressDialog(context);//创建一个ProgressDialog的实例
        progressDialog.setProgressDrawable(getResources().getDrawable(R.drawable.dialog_color));//设置背景色,设置进度条颜色
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//样式_水平
        progressDialog.setMax(100);//最大值
        progressDialog.setCancelable(false);//设置可否用back键关闭对话框
        progressDialog.setCustomTitle(title);//设置自定义标题
        progressDialog.setProgress(0);//设定进度
        return progressDialog;
    }
    /*
     * 方法名： download()
     * 功    能：下载apk，保存到本地，安装apk
     * 参    数：无
     * 返回值：无
     */
    private void download(String apkUrl) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(apkUrl)
                .build();
        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG-失败", e.toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.cancel();
                        Toast.makeText(getApplication(), "网络请求失败！", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws FileNotFoundException {
                Log.e("TAG-下载成功", response.code() + "---" + response.body().toString());
                //设置apk存储路径和名称
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/为步.apk");
                //保存文件到本地
                localStorage(response, file);
            }
        });
    }
    /*
     * 方法名：localStorage(final Response response, final File file)
     * 功    能：保存文件到本地
     * 参    数：Response response, File file
     * 返回值：无
     */
    private void localStorage(final Response response, final File file) throws FileNotFoundException {
        //拿到字节流
        InputStream is = response.body().byteStream();
        int len = 0;
        final FileOutputStream fos = new FileOutputStream(file);
        byte[] buf = new byte[2048];
        try {
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
                Log.e("TAG每次写入到文件大小", "onResponse: " + len);
                Log.e("TAG保存到文件进度：", file.length() + "/" + response.body().contentLength());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.setProgress((int) (file.length() * 100 / response.body().contentLength()));//当前文件长度除以文件总长度乘以100，返回int值。
                        //如果当前文件长度等于文件总长度与progressDialog框存在
                        if (file.length() == response.body().contentLength() && progressDialog.isShowing()) {
                            //进度重置，关闭进度框
                            progressDialog.setProgress(0);
                            progressDialog.cancel();
                            //弹出对话框，提示是否安装
                            new AlertView("下载完成", "是否立即安装?", null, null, new String[]{"取消", "安装"}, SettingActivity.this, AlertView.Style.Alert, new OnItemClickListener() {
                                public void onItemClick(Object o, int position) {
                                    switch (position) {
                                        case 1:
                                            installingAPK(file);
                                            break;
                                    }
                                }
                            }).show();
                        }
                    }
                });
            }
            fos.flush();
            fos.close();
            is.close();
        } catch (IOException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressDialog.setProgress(0);
                    progressDialog.cancel();
                    Toast.makeText(SettingActivity.this, "下载失败！", Toast.LENGTH_SHORT).show();
                }
            });
            e.printStackTrace();
        }
    }
    /*
     * 方法名：installingAPK(File file)
     * 功    能：安装apk,适配安卓6.0,7.0,8.0
     * 参    数：File file
     * 返回值：无
     */
    private void installingAPK(File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //安卓7.0以上需要在在Manifest.xml里的application里，设置provider路径
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(this, "com.gannan.gannan.fileprovider", new File(file.getPath()));
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        startActivity(intent);
    }

    protected void onStop() {
//        stop();
        super.onStop();
        Log.i("SettingActivity", "SettingActivity-->onStop()");
        SettingActivity.this.finish();

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.i("SettingActivity", "SettingActivity-->onDestroy()");
        //销毁时停止定时
//        stop();
        //销毁线程
        SettingActivity.this.finish();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE_SETTING: {
                Toast.makeText(this, R.string.message_setting_back, Toast.LENGTH_LONG).show();
                //设置成功，再次请求更新
//                getVersion(Tools.getVersion(SettingActivity.this));
                break;
            }
        }
    }

}
