package com.example.develop.progect2;

import android.app.Dialog;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;



public class DialogWindowAgain {

    private MainActivity activity;
    private Dialog dialog;
    private Button buttonOk;

    private String  phone;

    public DialogWindowAgain(MainActivity activity, String phone) {
        this.activity = activity;
        this.phone = phone;
        init();
    }


    private void init() {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View layout = inflater.inflate(R.layout.dialog_pay_again, null);
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
            /*AsyncRequest asyncTask = new AsyncRequest(phone);
            asyncTask.execute();*/
            dialog.dismiss();
        }
    };

    public Dialog getDialog() {
        return dialog;
    }

}
