package com.lkkdesign.buwei.util;

/**
 * 自定义加载dialog
 * Created by huangyaoyu on 2018-09-20.
 */

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.lkkdesign.buwei.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyLoadingDialog extends Dialog {

    @BindView(R.id.txt_wait)
    TextView txt_info;

    public MyLoadingDialog(Context context, String stringText) {
        super(context, R.style.MyDialogStyle);
        this.setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
        txt_info.setText(stringText);
    }

    public void setMsg(String msg) {
        if (null != txt_info) {
            txt_info.setText(msg);
        }
    }

}