package com.example.develop.progect2;

import android.os.AsyncTask;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.Random;

/**
 * Created by develop on 23.05.2016.
 */
public class AsyncRequest2 extends AsyncTask<Void, Void, Void> {

    private String phone;

    public AsyncRequest2(String str) {
        phone = str;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            DefaultHttpClient hc = new DefaultHttpClient();
            ResponseHandler response = new BasicResponseHandler();
            String req;
            req = ("http://api.prostor-sms.ru/messages/v2/send/?phone=%2B7" + phone + "&text=Для%20проведения%20оплаты%20ответьте%20кодом%20" + getRandom() + "%20на%20этот%20номер&login=ap136013&password=756379");
            HttpGet http = new HttpGet(req);

            String res = (String) hc.execute(http, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getRandom() {
        Random random = new Random();
        return Integer.toString(random.nextInt(100) + 300);
    }

}
