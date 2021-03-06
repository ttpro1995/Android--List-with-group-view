package com.ttpro.haha.example2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by haha on 1/1/2015.

 */
public class CustomAdapter extends ArrayAdapter {
   private Context context;
    private ArrayList<Work> objects;
    private  int resource;
    public CustomAdapter(Context context, int resource, ArrayList<Work> objects) {
        super(context, resource, objects);
    this.context=context;
        this.objects=objects;
        this.resource=resource;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View workView = convertView;
        if (workView==null)
        {
            workView = new CustomView(getContext());
        }



      final  Work tmp = objects.get(position);

        //bind with workView
        TextView workContent = ((CustomView)workView).WorkContent;
        TextView timeContent =((CustomView)workView).TimeContent;
        CheckBox checkBox = ((CustomView)workView).checkBox;

        //set text in textview
        workContent.setText(tmp.getWork());
        timeContent.setText(tmp.getTime());
        checkBox.setChecked(tmp.isChecked());
         checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 tmp.setChecked(isChecked);
             }
         });

        return workView;
    }
}
