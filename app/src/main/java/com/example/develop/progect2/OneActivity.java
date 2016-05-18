package com.example.develop.progect2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class OneActivity extends Fragment {

    private View view;
    private Button buttonPay;
    private EditText textNumber;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        textNumber = (EditText) view.findViewById(R.id.editText);
        //buttonPay.setOnClickListener(clickButtonPay);
        return view;
    }

    private void showToast(String t) {
        Toast toast = Toast.makeText(getActivity(), t, Toast.LENGTH_SHORT);
        toast.show();
    }

    /*View.OnClickListener clickButtonPay = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showToast("Нажата кнопка");
        }
    };*/
}
