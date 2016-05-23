package com.example.develop.progect2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by develop on 22.05.2016.
 */
public class AddCardActivity  extends Activity {

    private String phone = "";
    MySingleton s;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_card_layout);
        s = (MySingleton)this.getApplication();
        final TextView textTag = (TextView) findViewById(R.id.editTag);
        final TextView textStatus = (TextView) findViewById(R.id.editStatus);

        Button buttonAdd = (Button) findViewById(R.id.buttonAddCard);
        buttonAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.getCards().addCard(textTag.getText().toString(), phone, textStatus.getText().toString());
            }
        });
    }
}
