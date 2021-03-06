package com.example.develop.progect2;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by develop on 22.05.2016.
 */
public class DialogIncorrectPhone {

    private MainActivity activity;
    private Dialog dialog;
    private Button buttonOk;


    public DialogIncorrectPhone(MainActivity activity) {
        this.activity = activity;
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View layout = inflater.inflate(R.layout.dialog_uncorrect_phone, null);
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