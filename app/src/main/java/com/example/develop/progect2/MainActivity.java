package com.example.develop.progect2;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private ViewPagerAdapter viewPagerAdapter;

    private TabLayout.Tab tab1;
    private TabLayout.Tab tab2;

    private NfcManager nfcManager;
    private Cards cards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nfcManager = new NfcManager(this);
        cards = new Cards();

        createElements();
        createTabs();
    }


    private void createElements() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void createTabs() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        tab1 = tabLayout.newTab();
        tab2 = tabLayout.newTab();
        tab1.setText("Идентификация");
        tab2.setText("Сканировать код");
        tabLayout.addTab(tab1, 0);
        tabLayout.addTab(tab2, 1);
        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicator));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void showToast(String t) {
        Toast toast = Toast.makeText(this, ("UID: " + t), Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (intent.getAction().equals(NfcAdapter.ACTION_TAG_DISCOVERED)) {
            try {
                String tag = nfcManager.ByteArrayToHexString(intent.getByteArrayExtra(NfcAdapter.EXTRA_ID));

                for(int i = 0; i < cards.getArrayCards().size(); i++) {
                    if(cards.getArrayCards().get(i).getID().equals(tag)) {
                        if (cards.compare(tag)) {
                            if (cards.compareTagAndLastTag(tag)) {
                                DataRequest data = new DataRequest(cards.getArrayCards().get(i).getID(), cards.getArrayCards().get(i).getPHONE(), cards.getArrayCards().get(i).getSTATUS());
                                DialogWindowAgain dialog = new DialogWindowAgain(this, data);
                                dialog.showDialog();
                            } else {
                                DataRequest data = new DataRequest(cards.getArrayCards().get(i).getID(), cards.getArrayCards().get(i).getPHONE(), cards.getArrayCards().get(i).getSTATUS());
                                DialogWindow dialog = new DialogWindow(this, getResources().getLayout(R.layout.dialog_cash_ok));
                                dialog.showDialog();

                                AsyncRequest asyncTask = new AsyncRequest(data);
                                asyncTask.execute();

                                cards.setLastPayment(tag);
                            }
                        }
                    }
                }

                showToast(tag);
            } catch (Exception e) {
                showToast(e.toString());
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        IntentFilter filter = new IntentFilter();
        filter.addAction(NfcAdapter.ACTION_TAG_DISCOVERED);
        filter.addAction(NfcAdapter.ACTION_NDEF_DISCOVERED);
        filter.addAction(NfcAdapter.ACTION_TECH_DISCOVERED);
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, new IntentFilter[]{filter}, nfcManager.techList);
    }

    @Override
    protected void onPause() {
        super.onPause();
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        nfcAdapter.disableForegroundDispatch(this);
    }

    protected void onStop() {
        super.onStop();
    }
}