package com.example.develop.progect2;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;



public class DialogWindowAgain {

    private MainActivity activity;
    private Dialog dialog;
    private Button buttonOk;

    private DataRequest data;

    public DialogWindowAgain(MainActivity activity, DataRequest data) {
        this.activity = activity;
        this.data = data;
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
        buttonOk.setOnClickListener(clickButtonOk);
    }

    public void showDialog() {
        dialog.show();
    }


    View.OnClickListener clickButtonOk = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AsyncRequest asyncTask = new AsyncRequest(data);
            asyncTask.execute();
            dialog.dismiss();
        }
    };

}
