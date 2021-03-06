package com.example.develop.progect2;

import android.os.AsyncTask;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;


class AsyncRequest extends AsyncTask<Void, Void, Void> {

    private Card card;

    public AsyncRequest(Card card) {
        this.card = card;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            DefaultHttpClient hc = new DefaultHttpClient();
            ResponseHandler response = new BasicResponseHandler();
            String req;
            if(card.getSTATUS().equals("yes"))
                req = ("http://api.prostor-sms.ru/messages/v2/send/?phone=%2B7" + card.getPHONE() + "&text=Поездка%20начата%2C%20тариф%2030%20рублей&login=ap136013&password=756379");
            else {
                req = ("http://api.prostor-sms.ru/messages/v2/send/?phone=%2B7" + card.getPHONE() + "&text=У%20вас%20не%20хватает%20средств%20на%20счету&login=ap136013&password=756379");
            }
            HttpGet http = new HttpGet(req);

            String res = (String) hc.execute(http, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
