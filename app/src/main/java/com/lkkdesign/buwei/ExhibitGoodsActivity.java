package com.lkkdesign.buwei;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lkkdesign.buwei.bean.ExhibitGoodsRequest;
import com.lkkdesign.buwei.bean.ExhibitGoodsResponse;
import com.lkkdesign.buwei.constants.ApiAddress;
import com.lkkdesign.buwei.constants.Constants;
import com.lkkdesign.buwei.util.CustomToast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.lkkdesign.buwei.util.ParamJson.formatUrlMap;


public class ExhibitGoodsActivity extends AppCompatActivity {


    @BindView(R.id.iv_return)
    ImageView ivReturn;
    @BindView(R.id.tv_show_name1)
    TextView tvShowName1;
    @BindView(R.id.btn_sel_name1)
    Button btnSelName1;
    @BindView(R.id.tv_show_num1)
    TextView tvShowNum1;
    @BindView(R.id.btn_sel_num1)
    Button btnSelNum1;
    @BindView(R.id.tv_show_name2)
    TextView tvShowName2;
    @BindView(R.id.btn_sel_name2)
    Button btnSelName2;
    @BindView(R.id.tv_show_num2)
    TextView tvShowNum2;
    @BindView(R.id.btn_sel_num2)
    Button btnSelNum2;
    @BindView(R.id.tv_show_name3)
    TextView tvShowName3;
    @BindView(R.id.btn_sel_name3)
    Button btnSelName3;
    @BindView(R.id.tv_show_num3)
    TextView tvShowNum3;
    @BindView(R.id.btn_sel_num3)
    Button btnSelNum3;
    @BindView(R.id.tv_show_name4)
    TextView tvShowName4;
    @BindView(R.id.btn_sel_name4)
    Button btnSelName4;
    @BindView(R.id.tv_show_num4)
    TextView tvShowNum4;
    @BindView(R.id.btn_sel_num4)
    Button btnSelNum4;
    @BindView(R.id.tv_show_name5)
    TextView tvShowName5;
    @BindView(R.id.btn_sel_name5)
    Button btnSelName5;
    @BindView(R.id.tv_show_num5)
    TextView tvShowNum5;
    @BindView(R.id.btn_sel_num5)
    Button btnSelNum5;
    @BindView(R.id.tv_show_name6)
    TextView tvShowName6;
    @BindView(R.id.btn_sel_name6)
    Button btnSelName6;
    @BindView(R.id.tv_show_num6)
    TextView tvShowNum6;
    @BindView(R.id.btn_sel_num6)
    Button btnSelNum6;
    @BindView(R.id.tv_show_name7)
    TextView tvShowName7;
    @BindView(R.id.btn_sel_name7)
    Button btnSelName7;
    @BindView(R.id.tv_show_num7)
    TextView tvShowNum7;
    @BindView(R.id.btn_sel_num7)
    Button btnSelNum7;
    @BindView(R.id.tv_show_name8)
    TextView tvShowName8;
    @BindView(R.id.btn_sel_name8)
    Button btnSelName8;
    @BindView(R.id.tv_show_num8)
    TextView tvShowNum8;
    @BindView(R.id.btn_sel_num8)
    Button btnSelNum8;
    @BindView(R.id.tv_show_name9)
    TextView tvShowName9;
    @BindView(R.id.btn_sel_name9)
    Button btnSelName9;
    @BindView(R.id.tv_show_num9)
    TextView tvShowNum9;
    @BindView(R.id.btn_sel_num9)
    Button btnSelNum9;
    @BindView(R.id.tv_show_name10)
    TextView tvShowName10;
    @BindView(R.id.btn_sel_name10)
    Button btnSelName10;
    @BindView(R.id.tv_show_num10)
    TextView tvShowNum10;
    @BindView(R.id.btn_sel_num10)
    Button btnSelNum10;
    @BindView(R.id.tv_show_name11)
    TextView tvShowName11;
    @BindView(R.id.btn_sel_name11)
    Button btnSelName11;
    @BindView(R.id.tv_show_num11)
    TextView tvShowNum11;
    @BindView(R.id.btn_sel_num11)
    Button btnSelNum11;
    @BindView(R.id.tv_show_name12)
    TextView tvShowName12;
    @BindView(R.id.btn_sel_name12)
    Button btnSelName12;
    @BindView(R.id.tv_show_num12)
    TextView tvShowNum12;
    @BindView(R.id.btn_sel_num12)
    Button btnSelNum12;
    @BindView(R.id.tv_show_name13)
    TextView tvShowName13;
    @BindView(R.id.btn_sel_name13)
    Button btnSelName13;
    @BindView(R.id.tv_show_num13)
    TextView tvShowNum13;
    @BindView(R.id.btn_sel_num13)
    Button btnSelNum13;
    @BindView(R.id.tv_show_name14)
    TextView tvShowName14;
    @BindView(R.id.btn_sel_name14)
    Button btnSelName14;
    @BindView(R.id.tv_show_num14)
    TextView tvShowNum14;
    @BindView(R.id.btn_sel_num14)
    Button btnSelNum14;
    @BindView(R.id.tv_show_name15)
    TextView tvShowName15;
    @BindView(R.id.btn_sel_name15)
    Button btnSelName15;
    @BindView(R.id.tv_show_num15)
    TextView tvShowNum15;
    @BindView(R.id.btn_sel_num15)
    Button btnSelNum15;
    @BindView(R.id.tv_show_name16)
    TextView tvShowName16;
    @BindView(R.id.btn_sel_name16)
    Button btnSelName16;
    @BindView(R.id.tv_show_num16)
    TextView tvShowNum16;
    @BindView(R.id.btn_sel_num16)
    Button btnSelNum16;
    @BindView(R.id.tv_show_name17)
    TextView tvShowName17;
    @BindView(R.id.btn_sel_name17)
    Button btnSelName17;
    @BindView(R.id.tv_show_num17)
    TextView tvShowNum17;
    @BindView(R.id.btn_sel_num17)
    Button btnSelNum17;
    @BindView(R.id.tv_show_name18)
    TextView tvShowName18;
    @BindView(R.id.btn_sel_name18)
    Button btnSelName18;
    @BindView(R.id.tv_show_num18)
    TextView tvShowNum18;
    @BindView(R.id.btn_sel_num18)
    Button btnSelNum18;
    @BindView(R.id.tv_show_name19)
    TextView tvShowName19;
    @BindView(R.id.btn_sel_name19)
    Button btnSelName19;
    @BindView(R.id.tv_show_num19)
    TextView tvShowNum19;
    @BindView(R.id.btn_sel_num19)
    Button btnSelNum19;
    @BindView(R.id.tv_show_name20)
    TextView tvShowName20;
    @BindView(R.id.btn_sel_name20)
    Button btnSelName20;
    @BindView(R.id.tv_show_num20)
    TextView tvShowNum20;
    @BindView(R.id.btn_sel_num20)
    Button btnSelNum20;
    @BindView(R.id.btn_ensure_exgoods)
    Button btnEnsureExgoods;
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    private Intent intent = new Intent();
    private int position;
    private String strName;
    //    Intent intent = new Intent();

    private ExhibiGoodsThread exhibiGoodsThread;
    private boolean booEGThread_stop = false;//线程停止标志

    private MyloadingDialog myloadingDialog;

    // 单选提示框
    private AlertDialog alertDialog;
    Map<Integer, String> mapName = new HashMap<Integer, String>();
    Map<Integer, String> mapGoodsId = new HashMap<Integer, String>();
    Map<Integer, Integer> mapNum = new HashMap<Integer, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit_goods);
        ButterKnife.bind(this);
        // KKKLApplication.getInstance().addActivity(this);
        myloadingDialog=new MyloadingDialog(this);
    }




    @OnClick({R.id.iv_return, R.id.tv_show_name1, R.id.btn_sel_name1, R.id.tv_show_num1, R.id.btn_sel_num1, R.id.tv_show_name2, R.id.btn_sel_name2, R.id.tv_show_num2, R.id.btn_sel_num2, R.id.tv_show_name3, R.id.btn_sel_name3, R.id.tv_show_num3, R.id.btn_sel_num3, R.id.tv_show_name4, R.id.btn_sel_name4, R.id.tv_show_num4, R.id.btn_sel_num4, R.id.tv_show_name5, R.id.btn_sel_name5, R.id.tv_show_num5, R.id.btn_sel_num5, R.id.tv_show_name6, R.id.btn_sel_name6, R.id.tv_show_num6, R.id.btn_sel_num6, R.id.tv_show_name7, R.id.btn_sel_name7, R.id.tv_show_num7, R.id.btn_sel_num7, R.id.tv_show_name8, R.id.btn_sel_name8, R.id.tv_show_num8, R.id.btn_sel_num8, R.id.tv_show_name9, R.id.btn_sel_name9, R.id.tv_show_num9, R.id.btn_sel_num9, R.id.tv_show_name10, R.id.btn_sel_name10, R.id.tv_show_num10, R.id.btn_sel_num10, R.id.tv_show_name11, R.id.btn_sel_name11, R.id.tv_show_num11, R.id.btn_sel_num11, R.id.tv_show_name12, R.id.btn_sel_name12, R.id.tv_show_num12, R.id.btn_sel_num12, R.id.tv_show_name13, R.id.btn_sel_name13, R.id.tv_show_num13, R.id.btn_sel_num13, R.id.tv_show_name14, R.id.btn_sel_name14, R.id.tv_show_num14, R.id.btn_sel_num14, R.id.tv_show_name15, R.id.btn_sel_name15, R.id.tv_show_num15, R.id.btn_sel_num15, R.id.tv_show_name16, R.id.btn_sel_name16, R.id.tv_show_num16, R.id.btn_sel_num16, R.id.tv_show_name17, R.id.btn_sel_name17, R.id.tv_show_num17, R.id.btn_sel_num17, R.id.tv_show_name18, R.id.btn_sel_name18, R.id.tv_show_num18, R.id.btn_sel_num18, R.id.tv_show_name19, R.id.btn_sel_name19, R.id.tv_show_num19, R.id.btn_sel_num19, R.id.tv_show_name20, R.id.btn_sel_name20, R.id.tv_show_num20, R.id.btn_sel_num20, R.id.btn_ensure_exgoods, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_return:
                intent.setClass(ExhibitGoodsActivity.this,SettingActivity.class);
                startActivity(intent);
                ExhibitGoodsActivity.this.finish();
                break;
            case R.id.tv_show_name1:
                break;
            case R.id.btn_sel_name1:
                selectProductNameAlertDialog(view,tvShowName1,1);
                Log.i("***","tvShowName1");
                break;
            case R.id.tv_show_num1:
                break;
            case R.id.btn_sel_num1:
                selectProductNumAlertDialog(view,tvShowNum1,1);
                break;
            case R.id.tv_show_name2:
                break;
            case R.id.btn_sel_name2:
                selectProductNameAlertDialog(view,tvShowName2,2);
                break;
            case R.id.tv_show_num2:
                break;
            case R.id.btn_sel_num2:
                selectProductNumAlertDialog(view,tvShowNum2,2);
                break;
            case R.id.tv_show_name3:
                break;
            case R.id.btn_sel_name3:
                selectProductNameAlertDialog(view,tvShowName3,3);
                break;
            case R.id.tv_show_num3:
                break;
            case R.id.btn_sel_num3:
                selectProductNumAlertDialog(view,tvShowNum3,3);
                break;
            case R.id.tv_show_name4:
                break;
            case R.id.btn_sel_name4:
                selectProductNameAlertDialog(view,tvShowName4,4);
                break;
            case R.id.tv_show_num4:
                break;
            case R.id.btn_sel_num4:
                selectProductNumAlertDialog(view,tvShowNum4,4);
                break;
            case R.id.tv_show_name5:
                break;
            case R.id.btn_sel_name5:
                selectProductNameAlertDialog(view,tvShowName5,5);
                break;
            case R.id.tv_show_num5:
                break;
            case R.id.btn_sel_num5:
                selectProductNumAlertDialog(view,tvShowNum5,5);
                break;
            case R.id.tv_show_name6:
                break;
            case R.id.btn_sel_name6:
                selectProductNameAlertDialog(view,tvShowName6,6);
                break;
            case R.id.tv_show_num6:
                break;
            case R.id.btn_sel_num6:
                selectProductNumAlertDialog(view,tvShowNum6,6);
                break;
            case R.id.tv_show_name7:
                break;
            case R.id.btn_sel_name7:
                selectProductNameAlertDialog(view,tvShowName7,7);
                break;
            case R.id.tv_show_num7:
                break;
            case R.id.btn_sel_num7:
                selectProductNumAlertDialog(view,tvShowNum7,7);
                break;
            case R.id.tv_show_name8:
                break;
            case R.id.btn_sel_name8:
                selectProductNameAlertDialog(view,tvShowName8,8);
                break;
            case R.id.tv_show_num8:
                break;
            case R.id.btn_sel_num8:
                selectProductNumAlertDialog(view,tvShowNum8,8);
                break;
            case R.id.tv_show_name9:
                break;
            case R.id.btn_sel_name9:
                selectProductNameAlertDialog(view,tvShowName9,9);
                break;
            case R.id.tv_show_num9:
                break;
            case R.id.btn_sel_num9:
                selectProductNumAlertDialog(view,tvShowNum9,9);
                break;
            case R.id.tv_show_name10:
                break;
            case R.id.btn_sel_name10:
                selectProductNameAlertDialog(view,tvShowName10,10);
                break;
            case R.id.tv_show_num10:
                break;
            case R.id.btn_sel_num10:
                selectProductNumAlertDialog(view,tvShowNum10,10);
                break;
            case R.id.tv_show_name11:
                break;
            case R.id.btn_sel_name11:
                selectProductNameAlertDialog(view,tvShowName11,11);
                break;
            case R.id.tv_show_num11:
                break;
            case R.id.btn_sel_num11:
                selectProductNumAlertDialog(view,tvShowNum11,11);
                break;
            case R.id.tv_show_name12:
                break;
            case R.id.btn_sel_name12:
                selectProductNameAlertDialog(view,tvShowName12,12);
                break;
            case R.id.tv_show_num12:
                break;
            case R.id.btn_sel_num12:
                selectProductNumAlertDialog(view,tvShowNum12,12);
                break;
            case R.id.tv_show_name13:
                break;
            case R.id.btn_sel_name13:
                selectProductNameAlertDialog(view,tvShowName13,13);
                break;
            case R.id.tv_show_num13:
                break;
            case R.id.btn_sel_num13:
                selectProductNumAlertDialog(view,tvShowNum13,13);
                break;
            case R.id.tv_show_name14:
                break;
            case R.id.btn_sel_name14:
                selectProductNameAlertDialog(view,tvShowName14,14);
                break;
            case R.id.tv_show_num14:
                break;
            case R.id.btn_sel_num14:
                selectProductNumAlertDialog(view,tvShowNum14,14);
                break;
            case R.id.tv_show_name15:
                break;
            case R.id.btn_sel_name15:
                selectProductNameAlertDialog(view,tvShowName15,15);
                break;
            case R.id.tv_show_num15:
                break;
            case R.id.btn_sel_num15:
                selectProductNumAlertDialog(view,tvShowNum15,15);
                break;
            case R.id.tv_show_name16:
                break;
            case R.id.btn_sel_name16:
                selectProductNameAlertDialog(view,tvShowName16,16);
                break;
            case R.id.tv_show_num16:
                break;
            case R.id.btn_sel_num16:
                selectProductNumAlertDialog(view,tvShowNum16,16);
                break;
            case R.id.tv_show_name17:
                break;
            case R.id.btn_sel_name17:
                selectProductNameAlertDialog(view,tvShowName17,17);
                break;
            case R.id.tv_show_num17:
                break;
            case R.id.btn_sel_num17:
                selectProductNumAlertDialog(view,tvShowNum17,17);
                break;
            case R.id.tv_show_name18:
                break;
            case R.id.btn_sel_name18:
                selectProductNameAlertDialog(view,tvShowName18,18);
                break;
            case R.id.tv_show_num18:
                break;
            case R.id.btn_sel_num18:
                selectProductNumAlertDialog(view,tvShowNum18,18);
                break;
            case R.id.tv_show_name19:
                break;
            case R.id.btn_sel_name19:
                selectProductNameAlertDialog(view,tvShowName19,19);
                break;
            case R.id.tv_show_num19:
                break;
            case R.id.btn_sel_num19:
                selectProductNumAlertDialog(view,tvShowNum19,19);
                break;
            case R.id.tv_show_name20:
                break;
            case R.id.btn_sel_name20:
                selectProductNameAlertDialog(view,tvShowName20,20);
                break;
            case R.id.tv_show_num20:
                break;
            case R.id.btn_sel_num20:
                selectProductNumAlertDialog(view,tvShowNum20,20);
                break;
            case R.id.btn_ensure_exgoods:

               /* exhibiGoodsThread = new ExhibiGoodsThread();
                exhibiGoodsThread.start();*/
                CustomToast.showToast(ExhibitGoodsActivity.this,"数据更新成功");

                break;
            case R.id.btn_cancel:
                intent.setClass(ExhibitGoodsActivity.this,SettingActivity.class);
                startActivity(intent);
                ExhibitGoodsActivity.this.finish();
                break;
        }
    }

    public void selectProductNameAlertDialog(final View view, TextView tv, final int intMapKey) {
        System.out.println("view=" + view);
        final TextView tView = tv;
        final String[] items = getResources().getStringArray(R.array.spinner_goodsname);
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("选择货道存放饮料名称");
        alertBuilder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int index) {
                //Toast.makeText(ExhibitGoodsActivity.this, items[index], Toast.LENGTH_SHORT).show();
                CustomToast.showToast(getApplication(), items[index]);
                tView.setText(items[index]);
                mapName.put(intMapKey, items[index]);
                mapGoodsId.put(intMapKey, Constants.convertNameToGoodsId(items[index]));
                System.out.println("名称：" + mapName);
                alertDialog.dismiss();
            }
        });
        alertBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                alertDialog.dismiss();

            }
        });
        alertDialog = alertBuilder.create();
        alertDialog.show();

    }

    public void selectProductNumAlertDialog(View view, TextView tv, final int intMapKey) {
        final TextView tView = tv;
        final String[] items = getResources().getStringArray(R.array.addgoodsnum);
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("选择货道存放饮料数量");
        alertBuilder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int index) {
                //Toast.makeText(ExhibitGoodsActivity.this, items[index], Toast.LENGTH_SHORT).show();
                tView.setText(items[index]);
                mapNum.put(intMapKey, Integer.parseInt(items[index]));
                System.out.println("数量：" + mapNum);
                alertDialog.dismiss();
            }
        });
        alertBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                alertDialog.dismiss();
            }
        });
        alertDialog = alertBuilder.create();
        alertDialog.show();
    }


    /**
     * 同步商品信息到后台
     */
    private class ExhibiGoodsThread extends Thread {

        @Override
        public void run() {
            super.run();
            while (!booEGThread_stop) {
                Map<String, String> paraMap = new HashMap<String, String>();
                paraMap.put("machineId", String.valueOf(Constants.machineId));

                //转换成键值对
                String strFormactUrl = formatUrlMap(paraMap, true, false);
                String strsgin = strFormactUrl + "&key=" + Constants.strKey;

                System.out.println("strsgin:" + strsgin);
                String strSign = Constants.md5(strsgin);
                ExhibitGoodsRequest EGRequest = new ExhibitGoodsRequest();
                EGRequest.setMachineId(Constants.machineId);
                EGRequest.setSign(strSign);
                List<ExhibitGoodsRequest.dataBean> list = new ArrayList<ExhibitGoodsRequest.dataBean>();
                for (Integer key : mapName.keySet()) {
                    ExhibitGoodsRequest.dataBean dataBean = new ExhibitGoodsRequest.dataBean();
                    dataBean.setGoodsId(mapGoodsId.get(key));
                    dataBean.setCargoroad(key);
                    dataBean.setBeverageName(mapName.get(key));
                    dataBean.setBeverageNum(mapNum.get(key));
                    list.add(dataBean);
                }
                EGRequest.setData(list);
                String strExhibitGoodsJson = Constants.gson.toJson(EGRequest);
                System.out.println("上货的Json：" + strExhibitGoodsJson);

                System.out.println("strGIBFJson_strJson=" + strExhibitGoodsJson);
                System.out.println("strGIBFJson_strUrl=" + ApiAddress.URL_exhibitGoods);

                OkHttpClient okHttpClient = new OkHttpClient();
                //创建一个RequestBody(参数1：数据类型 参数2传递的json串)
                RequestBody requestBody = RequestBody.create(Constants.JSON, strExhibitGoodsJson);

                Request request = new Request.Builder()
                        .url(ApiAddress.URL_exhibitGoods)
                        .post(requestBody)
                        .build();
                Call call = okHttpClient.newCall(request);
                try {
                    Response response = call.execute();
                    String strjson = response.body().string();
                    Log.i("json-ExGResponse", "json-ExGResponse=" + strjson);
                    booEGThread_stop = true;//线程停止标志位
                    //判断请求是否成功
                    if (response.isSuccessful()) {
                        booEGThread_stop = true;//线程停止标志位
                        /**
                         * errCode	true	int	返回状态码：0表示没有错误，其他有错误
                         errMsg	true	String	errCode是非0的情况下是字符串，否则是null
                         integral	true	int	本次回收瓶子产生的积分
                         recoveryNum	true	int	个人累计回收瓶子数量
                         recoverySum	true	int	个人累计回收瓶子产生的总积分
                         sign	true	String	MD5签名
                         */
                        ExhibitGoodsResponse ExGResponse = Constants.gson.fromJson(strjson, ExhibitGoodsResponse.class);
                        int intErrCode = ExGResponse.getErrCode();
                        String strErrMsg = ExGResponse.getErrMsg();
                        //int intIntegral = GIBFResponse.getIntegral();

                        String strsign = ExGResponse.getSign();
                        if (200 == intErrCode) {
                            CustomToast.showToast(ExhibitGoodsActivity.this,"数据已同步到后台");
                        } else {
                            CustomToast.showToast(ExhibitGoodsActivity.this,"数据更新失败！\n原因："+strErrMsg);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void close() {
            booEGThread_stop = true;//线程停止标志位
        }
    }

    public void onDestroy() {
        booEGThread_stop = true;//线程停止标志位
        super.onDestroy();
        ExhibitGoodsActivity.this.finish();
        //animationView.cancelAnimation();
        System.out.println("RecyclePointsActivity-onDestroy()");
    }

}
