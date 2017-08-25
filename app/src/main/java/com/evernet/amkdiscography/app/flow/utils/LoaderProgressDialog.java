package com.evernet.amkdiscography.app.flow.utils;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.AppCompatTextView;


import com.evernet.amkdiscography.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class LoaderProgressDialog extends Dialog {

    @Bind(R.id.textLoading)
    AppCompatTextView textLoading;
    private String mMessage;


    public static LoaderProgressDialog newInstance(Context context) {
        LoaderProgressDialog dialog = new LoaderProgressDialog(context);
        return dialog;
    }

    public static LoaderProgressDialog newInstance(Context context, String message) {
        LoaderProgressDialog dialog = new LoaderProgressDialog(context, message);
        return dialog;
    }


    public LoaderProgressDialog(Context context) {
        super(context, R.style.Theme_Dialog_Transparent);
        this.setContentView(R.layout.loading_dialog);
        ButterKnife.bind(this);
        setCancelable(false);
    }

    public LoaderProgressDialog(Context context, String message) {
        super(context, R.style.Theme_Dialog_Transparent);
        this.setContentView(R.layout.loading_dialog);
        ButterKnife.bind(this);
        setCancelable(false);
        textLoading.setMaxLines(10);
        textLoading.setText(message);

    }
}

