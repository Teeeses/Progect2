package com.example.develop.progect2;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by develop on 22.05.2016.
 */
public class PhoneListActivity extends ListActivity {

    private Button buttonAdd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_phone);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        ArrayList<String> list = new ArrayList<>();

        try {
            XmlPullParser parser = getResources().getXml(R.xml.data_tags);
            XmlResourceParser par = getResources().getXml(R.xml.data_tags);


            while (parser.getEventType()!= XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() == XmlPullParser.START_TAG
                        && parser.getName().equals("contact")) {
                    list.add("TAG: " + parser.getAttributeValue(0) + "\n" +
                            "PHONE: +7" +  parser.getAttributeValue(1) + "\n" +
                            "STATUS: " + parser.getAttributeValue(2));
                }
                parser.next();
            }
        }
        catch (Throwable t) {}

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        this.setListAdapter(adapter);

        buttonAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PhoneListActivity.this, AddCardActivity.class);
                startActivity(i);
            }
        });
    }

}