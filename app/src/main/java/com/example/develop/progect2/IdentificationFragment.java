package com.example.develop.progect2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class IdentificationFragment extends Fragment {

    private View view;
    private Button buttonPay;
    private EditText textNumber;

    public static final String BASE_URL = "https://api.prostor-sms.ru";

    private Gson gson = new GsonBuilder().create();

    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build();

    private ServiceAPI interf = retrofit.create(ServiceAPI.class);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.identification, container, false);

        textNumber = (EditText) view.findViewById(R.id.maskedEditText);
        buttonPay = (Button) view.findViewById(R.id.buttonPay);

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = getPhoneNumber();

                Call<Object> call = interf.sendRequest(("%2B7" + getPhoneNumber()), "test", "ap136013", "756379");

                if(str.length() == 10) {
                    textNumber.setText("");
                    AsyncRequest asyncTask = new AsyncRequest(str);
                    asyncTask.execute();

                }
                else {
                    DialogWindow dialog = new DialogWindow((MainActivity) getActivity(), getResources().getLayout(R.layout.dialog_uncorrect_phone));
                    dialog.showDialog();
                }

                //}

                /*Call<Object> call = interf.sendRequest(("%2B7" + getPhoneNumber()), "test", "ap136013", "756379");
                Log.i("TAG", call.toString());*/

                /*Map<String, String> mapJson = new HashMap<String, String>();
                mapJson.put("phone", "%2B79056471378");
                mapJson.put("text", "test");
                mapJson.put("login", "ap136013");
                mapJson.put("password", "756379");*/



                /*Map<String, String> parameters = new HashMap<String, String>();
                parameters.put(("phone"), ("%2B7" + getPhoneNumber()));
                parameters.put("text", "test");
                parameters.put("login", "ap136013");
                parameters.put("password", "756379");
                Call<Object> call = interf.send(parameters);

                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        String str = response.body().toString();
                        Log.i("TAG", str);
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {

                    }
                });*/
            }
        });

        return view;
    }

    private String getPhoneNumber() {
        String phoneResult = textNumber.getText().toString();
        phoneResult = phoneResult.replaceAll("[^0-9]", "");
        phoneResult = phoneResult.replaceFirst("7", "");
        return phoneResult;
    }

}
