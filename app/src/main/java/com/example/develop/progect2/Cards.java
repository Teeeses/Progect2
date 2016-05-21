package com.example.develop.progect2;


public class Cards {

    private final String[] TAG = {"8BB5DE2F", "776F9AED"};
    private final String PHONE = "9056471378";

    private String[] last_payment = {""};

    public Cards() {}

    public boolean Compare(String tag) {
        for(int i = 0; i < TAG.length; i++) {
            if(TAG[i].equals(tag)) {
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
        for(int i = 0; i < last_payment.length; i++) {
            if(last_payment[i].equals(tag))
                return true;
        }
        return false;
    }

    public void setLastPayment(String tag) {
        if(!compareTagAndLastTag(tag))
            last_payment[last_payment.length] = tag;
    }

    public String getPhone() {
        return PHONE;
    }

}
