package com.example.develop.progect2;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class DialogQuestion {

    private MainActivity activity;
    private Dialog dialog;
    private Button buttonOk;
    private Button buttonCancel;

    private Card card;

    private boolean showedDialog = false;

    public DialogQuestion() {
        showedDialog = false;
    }

    public DialogQuestion(MainActivity activity, Card card) {
        this.activity = activity;
        this.card = card;
        showedDialog = true;
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View layout = inflater.inflate(R.layout.dialog_question, null);
        layout.setPadding(20, 20, 20, 20);
        buttonOk = (Button) layout.findViewById(R.id.buttonOk);
        buttonCancel = (Button) layout.findViewById(R.id.buttonCancel);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(layout);
        dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        buttonOk.setOnClickListener(clickButtonOk);
        buttonCancel.setOnClickListener(clickButtonCancel);
    }

    public void showDialog() {
        dialog.show();
    }


    View.OnClickListener clickButtonOk = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(card.getSTATUS().equals("yes")) {

                AsyncRequest asyncTask = new AsyncRequest(card);
                asyncTask.execute();
                Toast.makeText(activity, "Оплата была произведена", Toast.LENGTH_LONG).show();

                /*DialogPay dialog = new DialogPay(activity, "Оплата была произведена");
                dialog.showDialog();*/
            } else {

                Toast.makeText(activity, "Нехватает средств", Toast.LENGTH_LONG).show();
                /*DialogPay dialog = new DialogPay(activity, "Нехватает средств");
                dialog.showDialog();*/
            }
            dialog.dismiss();
        }
    };

    View.OnClickListener clickButtonCancel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showedDialog = false;
            dialog.dismiss();
        }
    };

    public boolean getShowedDialog() {
        return showedDialog;
    }

    public void setShowedDialog(boolean boo) {
        showedDialog = boo;
    }

}
