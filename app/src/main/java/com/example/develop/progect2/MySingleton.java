package com.example.develop.progect2;

import android.app.Application;
import android.content.res.Resources;

/**
 * Created by develop on 23.05.2016.
 */
public final class MySingleton extends Application {
    private Cards cards;

    @Override
    public void onCreate() {
        super.onCreate();
        cards = new Cards();
    }

    public Cards getCards() {
        return cards;
    }
}
