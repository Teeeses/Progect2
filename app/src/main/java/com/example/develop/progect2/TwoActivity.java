package com.example.develop.progect2;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;



public class TwoActivity extends Fragment implements QRCodeReaderView.OnQRCodeReadListener{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private View view;
    private QRCodeReaderView mydecoderview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.qr_decoder, container, false);


        mydecoderview = (QRCodeReaderView) view.findViewById(R.id.qrdecoderview);
        mydecoderview.setOnQRCodeReadListener(this);

        return view;
    }

    private void showToast(String t) {
        Toast toast = Toast.makeText(getActivity(), t, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        showToast(text);
    }


    @Override
    public void cameraNotFound() {

    }

    @Override
    public void QRCodeNotFoundOnCamImage() {

    }

    @Override
    public void onResume() {
        super.onResume();
        mydecoderview.getCameraManager().startPreview();
    }

    @Override
    public void onPause() {
        super.onPause();
        mydecoderview.getCameraManager().stopPreview();
    }

}