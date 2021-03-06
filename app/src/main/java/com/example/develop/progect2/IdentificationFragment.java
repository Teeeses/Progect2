package com.example.develop.progect2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.github.pinball83.maskededittext.MaskedEditText;


public class IdentificationFragment extends Fragment {

    private View view;
    private Button buttonPay;
    private EditText textNumber;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.identification, container, false);

        textNumber = (EditText) view.findViewById(R.id.maskedEditText);
        buttonPay = (Button) view.findViewById(R.id.buttonPay);

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = getPhoneNumber();

                if(str.length() == 10) {
                    AsyncRequest2 asyncTask = new AsyncRequest2(str);
                    asyncTask.execute();
                }
                else {
                    DialogIncorrectPhone dialog = new DialogIncorrectPhone((MainActivity) getActivity());
                    dialog.showDialog();
                }
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
