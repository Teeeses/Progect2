package com.example.develop.progect2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class OneActivity extends Fragment {

    private View view;
    private Button buttonPay;
    private EditText textNumber;

    public static final String BASE_URL = "https://api.prostor-sms.ru";

    private Gson gson = new GsonBuilder().create();

    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build();

    private ServiceAPI intf = retrofit.create(ServiceAPI.class);


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        textNumber = (EditText) view.findViewById(R.id.maskedEditText);
        buttonPay = (Button) view.findViewById(R.id.buttonPay);

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showToast("Нажата");

                MyTask mt = new MyTask();

                mt.execute();

                //Call<Object> call = intf.sendRequest(("%2B79056471378"), "test", "ap136013", "756379");


                /*Map<String, String> mapJson = new HashMap<String, String>();
                mapJson.put("phone", "%2B79056471378");
                mapJson.put("text", "test");
                mapJson.put("login", "ap136013");
                mapJson.put("password", "756379");

                Call<Object> call = intf.sendRequest(mapJson);*/

                /*try {
                    Response<Object> response = call.execute();
                }catch (Exception e) {
                    e.printStackTrace();
                }*/



                /*intf.sendRequest(("%2B79056471378"), "test", "ap136013", "756379", new Callback<Response>(){
                    public void success(Response arg0, retrofit.client.Response arg1) {

                    }

                    public void failure(RetrofitError arg0) {

                    }
                });*/


                /*Map<String, String> parameters = new HashMap<String, String>();
                parameters.put(("%2B79056471378"), "test");
                parameters.put("ap136013", "756379");
                Response response = intf.sendRequest(parameters);*/



                /*try {

                    Response<Object> response = call.execute();
                    //Map<String, String> map = gson.fromJson(response.body().toString(), Map.class);
*/
                /*String str;
                    call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                            str = response.body().toString();
                            System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFF" + str);
                            Log.i("TAG", str);
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {

                        }
                    });*/


                /*} catch (IOException e) {
                    e.printStackTrace();
                    Log.i("TAG", e.toString());
                }*/

            }
        });

        return view;
    }



    class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                /*DefaultHttpClient hc = new DefaultHttpClient();
                ResponseHandler response = new BasicResponseHandler();
                HttpGet http = new HttpGet("http://api.prostor-sms.ru/messages/v2/send/?phone=%2B79056471378&text=test&login=ap136013&password=756379");

                String res = (String) hc.execute(http, response);*/
                Log.i("TAG", res);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

    }



    private void showToast(String t) {
        Toast toast = Toast.makeText(getActivity(), t, Toast.LENGTH_SHORT);
        toast.show();
    }

}
