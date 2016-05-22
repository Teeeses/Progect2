package com.example.develop.progect2;

/**
 * Created by develop on 22.05.2016.
 */
public class DataRequest {

    public String ID;
    public String PHONE;
    public String STATUS;

    public DataRequest() {}

    public DataRequest(String id, String phone, String status) {
        ID = id;
        PHONE = phone;
        STATUS = status;
    }

    public String getID() {
        return ID;
    }

    public String getPHONE() {
        return PHONE;
    }

    public String getSTATUS() {
        return STATUS;
    }
}
