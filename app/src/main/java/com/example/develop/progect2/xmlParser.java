package com.example.develop.progect2;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

/**
 * Created by develop on 22.05.2016.
 */
public class xmlParser {

    private ArrayList<Card> list;
    private XmlPullParser parser;

    public xmlParser(MainActivity activity) {
        list = new ArrayList<>();
        try {
            parser = activity.getResources().getXml(R.xml.data_tags);

            while (parser.getEventType()!= XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() == XmlPullParser.START_TAG
                        && parser.getName().equals("contact")) {
                    list.add(new Card(parser.getAttributeValue(0),  parser.getAttributeValue(1),  parser.getAttributeValue(2)));
                }
                parser.next();
            }
        }
        catch (Throwable t) {}
    }

    public boolean getBool(String tag) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getID().equals(tag)) {
                return true;
            }
        }
        return false;
    }

    public Card getCard(String tag) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getID().equals(tag)) {
                return list.get(i);
            }
        }
        return null;
    }

    public int getSize() {
        return list.size();
    }

    public ArrayList<Card> getList() {
        return list;
    }

}
