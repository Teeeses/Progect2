package com.example.develop.progect2;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


public class DialogQuestion {

    private MainActivity activity;
    private Dialog dialog;
    private Button buttonOk;

    private Card card;

    public DialogQuestion(MainActivity activity, Card card) {
        this.activity = activity;
        this.card = card;
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View layout = inflater.inflate(R.layout.dialog_question, null);
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
            AsyncRequest asyncTask = new AsyncRequest(card);
            asyncTask.execute();
            dialog.dismiss();
        }
    };

}
