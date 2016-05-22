package com.example.develop.progect2;

import android.os.AsyncTask;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;


class AsyncRequest extends AsyncTask<Void, Void, Void> {

    private DataRequest data = new DataRequest();

    public AsyncRequest(DataRequest data) {
        this.data = data;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            DefaultHttpClient hc = new DefaultHttpClient();
            ResponseHandler response = new BasicResponseHandler();
            String req = ("http://api.prostor-sms.ru/messages/v2/send/?phone=%2B7" + data.getPHONE() + "&text=" + data.getSTATUS() + "&login=ap136013&password=756379");
            HttpGet http = new HttpGet(req);

            String res = (String) hc.execute(http, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
