package com.example.develop.progect2;


import java.util.ArrayList;

public class Cards {

    private ArrayList<String> TAG = new ArrayList<String>();
    private String PHONE = "9056471378";

    private ArrayList<String> last_payment = new ArrayList<>();

    public Cards() {
        TAG.add("8BB5DE2F");
        TAG.add("776F9AED");
    }

    public boolean Compare(String tag) {
        for(int i = 0; i < TAG.size(); i++) {
            if(TAG.get(i).equals(tag)) {
                return true;
            }
        }
        return false;
    }

    public void sendSMS() {
        AsyncRequest asyncTask = new AsyncRequest(PHONE);
        asyncTask.execute();
    }

    public boolean compareTagAndLastTag(String tag) {
        for(int i = 0; i < last_payment.size(); i++) {
            if(last_payment.get(i).equals(tag))
                return true;
        }
        return false;
    }

    public void setLastPayment(String tag) {
        if(!compareTagAndLastTag(tag))
            last_payment.add(tag);
    }

    public String getPhone() {
        return PHONE;
    }

}
