package com.example.develop.progect2;


import java.util.TimerTask;

class TimerTaskClose extends TimerTask {


    private MainActivity activity;

    public TimerTaskClose(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void run() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}