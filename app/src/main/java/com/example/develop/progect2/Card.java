package com.example.develop.progect2;

public class Card {

    public String ID;
    public String PHONE;
    public String STATUS;

    public Card(String id, String phone, String status) {
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
