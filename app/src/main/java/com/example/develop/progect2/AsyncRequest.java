package com.example.develop.progect2;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

class AsyncRequest extends AsyncTask<Void, Void, Void> {

    private String phoneNumber;

    public AsyncRequest(String phone) {
        phoneNumber = phone;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            DefaultHttpClient hc = new DefaultHttpClient();
            ResponseHandler response = new BasicResponseHandler();
            String req = ("http://api.prostor-sms.ru/messages/v2/send/?phone=%2B7" + phoneNumber + "&text=test&login=ap136013&password=756379");
            HttpGet http = new HttpGet(req);

            String res = (String) hc.execute(http, response);
            Log.i("TAG", res);
        } catch (Exception e) {
            e.printStackTrace();
        }

            /*call.enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {
                    String str = response.body().toString();
                    Log.i("TAG", str);
                }

                @Override
                public void onFailure(Call<Object> call, Throwable t) {

                }
            });*/

        return null;
    }

}
