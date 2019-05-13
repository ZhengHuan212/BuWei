package com.lkkdesign.buwei.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


import com.lkkdesign.buwei.R;
import com.lkkdesign.buwei.util.AppSharePreferenceMgr;
import com.lkkdesign.buwei.util.MyLoadingDialog;
import com.lkkdesign.buwei.util.NetworkConnectChangedReceiver;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ---------------------------------------------------------------------
 * Copyright © 2018-2020, 深圳洛可可设计工业有限公司, All rights reserved.
 * ---------------------------------------------------------------------
 *
 * @File: APPActivity.java
 * @Author: admin
 * @Version: V1.0
 * @Create: 2018/6/28 14:57
 * @Description: //APP基本Activity类
 * <p>
 * ---------------------------------------------------------------------
 * @Project: ZuoYuoWeiLai
 * ---------------------------------------------------------------------
 */
public abstract class APPActivity extends AppCompatActivity {
    private Unbinder mUnBinder;
    //    private boolean stopThread = false;
//    SerialControl serialControl;
//    public SerialControl ComDoor;//扫打开柜门
//    public DispQueueThread DispQueue;//刷新显示线程
    public static String strMachineId;
    public MyLoadingDialog myLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        strMachineId = (String) AppSharePreferenceMgr.get(this, "machineId", "");

        checkNetwork(this);

        myLoadingDialog = new MyLoadingDialog(this, "正在处理，请等待……");
        myLoadingDialog.setCanceledOnTouchOutside(false);

//        DispQueue = new DispQueueThread();
//        DispQueue.start();
//        ComDoor = new SerialControl();//柜门串口
//        openDoorPort();//打开串口
    }

//    //打开柜门串口
//    public void openDoorPort() {
//        //柜门
//        ComDoor.setPort(Constants.strDoorPort);
//        ComDoor.setBaudRate(Constants.intBaudRate_9600);
//        OpenComPort(ComDoor);
//
//    }

    // 如果没有网络，则弹出网络设置对话框
    public static void checkNetwork(final Activity activity) {
        TextView msg = new TextView(activity);
        msg.setText("\t\t\t当前没有可以使用的网络，请检查网络！");
        msg.setTextSize(22.0f);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog alertDialog = builder.create();
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("重要提示");
        builder.setView(msg);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        if (!NetworkConnectChangedReceiver.isNetworkAvalible(activity)) {
            alertDialog.show();
        } else {
            if (alertDialog.isShowing() || alertDialog != null)
                alertDialog.dismiss();
        }

        return;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        injectView();
    }

    public void injectView() {
        mUnBinder = ButterKnife.bind(this);
    }

//    // ----------------------------------------------------串口控制类
//    public class SerialControl extends SerialHelper {
//
//        public SerialControl() {
//        }
//
//        @Override
//        protected void onDataReceived(final ComBean ComRecData) {
//            //数据接收量大或接收时弹出软键盘，界面会卡顿,可能和6410的显示性能有关
//            //直接刷新显示，接收数据量大时，卡顿明显，但接收与显示同步。
//            //用线程定时刷新显示可以获得较流畅的显示效果，但是接收数据速度快于显示速度时，显示会滞后。
//            //最终效果差不多-_-，线程定时刷新稍好一些。
//            DispQueue.AddQueue(ComRecData);//线程定时刷新显示(推荐)
//            /*
//            runOnUiThread(new Runnable()//直接刷新显示
//			{
//				public void run()
//				{
//					DispRecData(ComRecData);
//				}
//			});*/
//        }
//    }
//
//    //----------------------------------------------------刷新显示线程
//    private class DispQueueThread extends Thread {
//        private Queue<ComBean> QueueList = new LinkedList<ComBean>();
//
//        @Override
//        public void run() {
//            super.run();
//            //while (!isInterrupted()) {
//            while (!stopThread) {
//                final ComBean ComData;
//                while ((ComData = QueueList.poll()) != null) {
//                    runOnUiThread(new Runnable() {
//                        public void run() {
//                            DispRecData(ComData);
//                        }
//                    });
//                    try {
//                        Thread.sleep(100);//默认100 显示性能高的话，可以把此数值调小。
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                }
//            }
//        }
//
//        public synchronized void AddQueue(ComBean ComData) {
//            QueueList.add(ComData);
//        }
//    }
//
//    //接收串口返回的数据
//    public void DispRecData(ComBean ComRecData) {
//        StringBuilder sMsg = new StringBuilder();
//        sMsg.append(ComRecData.sRecTime);
//        sMsg.append("[");
//        sMsg.append(ComRecData.sComPort);
//        sMsg.append("]");
//        sMsg.append("[Hex] ");
//        String strData = new String(ComRecData.bRec);
//        sMsg.append(strData);
//        Log.i("RData", "接收的数据1：" + new String(ComRecData.bRec));
//        Log.i("RData", "接收的数据2：" + ByteArrToHex(ComRecData.bRec));
//
//        if ("/dev/ttyS3".equals(ComRecData.sComPort)) {//柜门 /dev/ttyS3返回的数据
//            Log.i("APPData", "串口数据：" + strData);
//            Constants.serialMapData.put("ttyS3", strData);
//            //searchBottleCode(strODCode);
//        } else {
//
//        }
//    }
//
//
//    //----------------------------------------------------设置自动发送延时
//    public void setDelayTime(String sTime) {
//        SetiDelayTime(serialControl, sTime);
//    }
//
//    //----------------------------------------------------设置自动发送数据
//    public void setSendData(String strSendPortData) {
//        SetLoopData(serialControl, strSendPortData);
//    }
//
//    //----------------------------------------------------设置自动发送延时
//    public void SetiDelayTime(SerialHelper ComPort, String sTime) {
//        ComPort.setiDelay(Integer.parseInt(sTime));
//    }
//
//    //----------------------------------------------------设置自动发送数据
//    public void SetLoopData(SerialHelper ComPort, String sLoopData) {
//
//        ComPort.setHexLoopData(sLoopData);
//    }
//
//    //----------------------------------------------------设置自动发送模式开关
//    public void SetAutoSend(SerialHelper ComPort, boolean isAutoSend) {
//        if (isAutoSend) {
//            ComPort.startSend();
//        } else {
//            ComPort.stopSend();
//        }
//    }
//
//    //---------------------------------------------------
//    // -串口发送十六进制数据
//    public void sendPortData_Hex(SerialHelper ComPort, String sOut) {
//        System.out.println("发送十六进制：" + sOut);
//        if (ComPort != null && ComPort.isOpen()) {
//            ComPort.sendHex(sOut);
//        }
//    }
//
//    //---------------------------------------------------
//    // -串口发送文本
//    public void sendPortData_Text(SerialHelper ComPort, String sOut) {
//        System.out.println("发送文本：" + sOut);
//        if (ComPort != null && ComPort.isOpen()) {
//            ComPort.sendTxt(sOut);
//        }
//    }
//
//    //----------------------------------------------------关闭串口
//    public void CloseComPort(SerialHelper ComPort) {
//        if (ComPort != null) {
//            ComPort.stopSend();
//            ComPort.close();
//        }
//    }
//
//    //----------------------------------------------------打开串口
//    public void OpenComPort(SerialHelper ComPort) {
//        try {
//            ComPort.open();
//            //ShowMessage(" 串口打开成功!");
//        } catch (SecurityException e) {
//            ShowMessage("打开串口失败:没有串口读/写权限!");
//        } catch (IOException e) {
//            ShowMessage("打开串口失败:未知错误!");
//        } catch (InvalidParameterException e) {
//            ShowMessage("打开串口失败:参数错误!");
//        }
//    }
//
//    //------------------------------------------显示消息
//    public void ShowMessage(String sMsg) {
//        //Toast.makeText(this, sMsg, Toast.LENGTH_SHORT).show();
//        CustomToast.showToast(getApplication(), sMsg);
//    }


    @Override
    protected void onStop() {
        super.onStop();
        cancle();
//        if (DispQueue.isAlive()) {
//            stopThread = true;//这样在线程执行run方法就会退出那个循环了
//        }
        APPActivity.this.finish();
        Log.i("APPActivity", "APPActivity-->onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancle();
//        if (DispQueue.isAlive()) {
//            //SerialHelper.close();
//            stopThread = true;//这样在线程执行run方法就会退出那个循环了
//        }
        APPActivity.this.finish();
        Log.i("APPActivity", "APPActivity-->onDestroy()");
        mUnBinder.unbind();
    }

    private void cancle() {

        if (myLoadingDialog != null && myLoadingDialog.isShowing()) {
            myLoadingDialog.dismiss();
        }

    }

}
