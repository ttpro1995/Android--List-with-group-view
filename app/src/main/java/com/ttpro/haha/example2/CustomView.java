package com.ttpro.haha.example2;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by haha on 12/31/2014.
 */
public class CustomView extends LinearLayout {
    public TextView WorkContent;
    public TextView TimeContent;

    public CustomView(Context context) {
        super(context);

        //set layout inflater
        LayoutInflater li= (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.item_with_title_and_time,this,true);//bind with layout xml

        //bind
        WorkContent = (TextView) findViewById(R.id.WorkText);
        TimeContent = (TextView) findViewById(R.id.TimeText);

    }
}
