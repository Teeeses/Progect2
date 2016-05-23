package com.example.develop.progect2;

import java.util.ArrayList;

/**
 * Created by develop on 23.05.2016.
 */
public class Cards {

    private ArrayList<Card> cards = new ArrayList<>();

    public Cards() {}

    public void addCard(String s, String k, String t) {
        cards.add(new Card(s, k, t));
    }

    public ArrayList<Card> getArrayCards() {
        return cards;
    }
}
