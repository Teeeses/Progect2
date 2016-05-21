package com.example.develop.progect2;

import android.app.Dialog;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;



public class DialogWindow {

    private MainActivity activity;
    private Dialog dialog;
    private Button buttonOk;

    public DialogWindow(MainActivity activity, XmlResourceParser res) {
        this.activity = activity;
        init(res);
    }

    private void init(XmlResourceParser res) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View layout = inflater.inflate(res, null);
        layout.setPadding(20, 20, 20, 20);
        buttonOk = (Button) layout.findViewById(R.id.buttonOk);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(layout);
        dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        buttonOk.setOnClickListener(clickButtonOk);
    }

    public void showDialog() {
        dialog.show();
    }


    View.OnClickListener clickButtonOk = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
        }
    };

}
