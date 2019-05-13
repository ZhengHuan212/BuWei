package com.lkkdesign.buwei.util;

/**
 * Created by huangyaoyu on 2018/6/8.
 * 通过注册广播，实时监听网络连接与断开状态的变化
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;


public class NetworkConnectChangedReceiver extends BroadcastReceiver {

    /**
     * 获取连接类型
     *
     * @param type
     * @return
     */
    private String getConnectionType(int type) {
        String connType = "";
        if (type == ConnectivityManager.TYPE_MOBILE) {
            connType = "移动网络数据";
        } else if (type == ConnectivityManager.TYPE_WIFI) {
            connType = "WIFI网络";
        }
        return connType;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(intent.getAction())) {// 监听wifi的打开与关闭，与wifi的连接无关
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
            Log.e("TAG", "wifiState:" + wifiState);
            switch (wifiState) {
                case WifiManager.WIFI_STATE_DISABLED:
                    break;
                case WifiManager.WIFI_STATE_DISABLING:
                    break;
            }
        }
        // 监听网络连接，包括wifi和移动数据的打开和关闭,以及连接上可用的连接都会接到监听
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            //获取联网状态的NetworkInfo对象
            NetworkInfo info = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            if (info != null) {
                //如果当前的网络连接成功并且网络连接可用
                if (NetworkInfo.State.CONNECTED == info.getState() && info.isAvailable()) {
                    if (info.getType() == ConnectivityManager.TYPE_WIFI || info.getType() == ConnectivityManager.TYPE_MOBILE) {
                        Log.i("TAG", getConnectionType(info.getType()) + "连上");
                        CustomToast.showToast(context, getConnectionType(info.getType()) + "已经连上");
                    }
                } else {
                    CustomToast.showToast(context, getConnectionType(info.getType()) + "已经断开");
                    Log.i("TAG", getConnectionType(info.getType()) + "断开");
                }
            }
        }
    }


    /**
     * 判断网络情况
     *
     * @param context 上下文
     * @return false 表示没有网络 true 表示有网络
     */
    public static boolean isNetworkAvalible(Context context) {
        // 获得网络状态管理器
        //ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        } else {
            // 建立网络数组
            NetworkInfo[] net_info = connectivityManager.getAllNetworkInfo();

            if (net_info != null) {
                for (int i = 0; i < net_info.length; i++) {
                    // 判断获得的网络状态是否是处于连接状态
                    if (net_info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
