package com.example.develop.progect2;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by develop on 23.05.2016.
 */
public class DialogPay {

    private MainActivity activity;
    private Dialog dialog;


    public DialogPay(MainActivity activity, String str) {
        this.activity = activity;
        init(str);
    }

    private void init(String str) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View layout = inflater.inflate(R.layout.dialog_question, null);
        TextView text = (TextView) layout.findViewById(R.id.pay);
        text.setText(str);
        layout.setPadding(20, 20, 20, 20);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(layout);
        dialog = builder.create();
    }

    public void showDialog() {
        dialog.show();
    }
}