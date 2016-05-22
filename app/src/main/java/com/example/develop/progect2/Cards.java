package com.example.develop.progect2;

import java.util.ArrayList;

/**
 * Created by develop on 22.05.2016.
 */
public class Cards {

    public ArrayList<Card> arrayCards = new ArrayList<>();

    private ArrayList<String> last_payment = new ArrayList<>();

    public Cards() {

        // ID - 1
        arrayCards.add(new Card("7B182B31", "9201051203", "no"));
        // ID - 2
        arrayCards.add(new Card("9B9B2B31", "9639261203", "yes"));
        // PURPLE
        arrayCards.add(new Card("8BB5DE2F", "9056471378", "yes"));

    }


    public boolean compare(String tag) {
        for(int i = 0; i < arrayCards.size(); i++) {
            if(arrayCards.get(i).getID().equals(tag)) {
                return true;
            }
        }
        return false;
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

    public ArrayList<Card> getArrayCards() {
        return arrayCards;
    }
}
