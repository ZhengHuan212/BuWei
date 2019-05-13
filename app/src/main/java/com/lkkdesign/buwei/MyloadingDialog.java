package com.lkkdesign.buwei;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

/**
 * 检测升级弹窗
 */
public class MyloadingDialog extends Dialog {

    private TextView tv_loading;

    public MyloadingDialog(Context context) {
        super(context);
        setContentView(R.layout.activity_update_toast);
        tv_loading=findViewById(R.id.tv_loading);
    }

    public void setTv_loading(String strTvloading) {
        tv_loading.setText(strTvloading);
    }
}
