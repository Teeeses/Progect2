package com.example.develop.progect2;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;


public class QRFragment extends Fragment /*implements QRCodeReaderView.OnQRCodeReadListener */{

    private View view;
    private QRCodeReaderView decoderView;
    private String qrCode = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.qr_decoder, container, false);

        /*decoderView = (QRCodeReaderView) view.findViewById(R.id.qrdecoderview);
        decoderView.setOnQRCodeReadListener(this);*/
        return view;
    }

    private void showToast(String t) {
        Toast toast = Toast.makeText(getActivity(), t, Toast.LENGTH_SHORT);
        toast.show();
    }



    /*@Override
    public void onQRCodeRead(String text, PointF[] points) {
        if(!qrCode.equals(text)) {
            qrCode = text;
            showToast(text);
        }
    }

    @Override
    public void cameraNotFound() {}

    @Override
    public void QRCodeNotFoundOnCamImage() {}*/




    @Override
    public void onResume() {
        super.onResume();
        /*try {
            decoderView.getCameraManager().startPreview();
        }catch (Exception e) {}*/
    }

    @Override
    public void onPause() {
        super.onPause();
        /*try {
            decoderView.getCameraManager().stopPreview();
        } catch (Exception e) {

        }*/
    }

}