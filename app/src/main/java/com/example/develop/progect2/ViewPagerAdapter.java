package com.example.develop.progect2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by develop on 16.05.2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new IdentificationFragment();
            case 1:
                return new QRFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

}