package com.ttpro.haha.example2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private EditText hour;
    private EditText min ;
    private EditText work;
    private ListView list;
    private Button submit_button;
   private ArrayList<Work> p_arr; // private ArrayList<String> p_arr;
    private Button clear_all;
    private Button Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hour = (EditText) findViewById(R.id.Edit_hour);
        min = (EditText) findViewById(R.id.Edit_min);
        work = (EditText) findViewById(R.id.Edit_Work);
        submit_button = (Button) findViewById(R.id.submit_button);
        list = (ListView) findViewById(R.id.list_item);
        p_arr = new ArrayList<Work>(); //p_arr = new ArrayList<String>();
        clear_all= (Button) findViewById(R.id.Clear_All);
        clear_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while (!p_arr.isEmpty())
                {
                    p_arr.clear();
                }
                //ArrayAdapter adapter;
                //adapter = new ArrayAdapter(MainActivity.this,R.layout.item,R.id.textView_item,p_arr);
                //list.setAdapter(adapter);

                CustomAdapter adapter;
                adapter = new CustomAdapter(MainActivity.this,R.layout.item_with_title_and_time,p_arr);
                list.setAdapter(adapter);
            }
        });


        Delete = (Button) findViewById(R.id.Delete_selected);
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<p_arr.size();i++)
                {
                    if (p_arr.get(i).isChecked())
                    {
                        p_arr.remove(i);
                    }
                }
                CustomAdapter adapter;
                adapter = new CustomAdapter(MainActivity.this,R.layout.item_with_title_and_time,p_arr);
                list.setAdapter(adapter);
            }
        });

    }

    public void submitWork(View v)
    {
        String h = hour.getText().toString();
        String m = min.getText().toString();
        String w = work.getText().toString();
        hour.setText("");
        min.setText("");
        work.setText("");
        if (h.equals(""))
            return;
        if (m.equals(""))
            return;
        if (w.equals(""))
            return;

        int INThour= Integer.parseInt(h) ;
        int INTmin =  Integer.parseInt(m);

        if (INThour>24)
            return;

        if (INThour<1)
            return;

        if (INTmin>60)
            return;

        if (INTmin<1)
            return;



        /*
        String out= w+" - "+h+":"+m;
       p_arr.add(out);

        ArrayAdapter adapter;
        adapter=new ArrayAdapter(this,R.layout.item,R.id.textView_item,p_arr);
        list.setAdapter(adapter);
        */

        String time = h+":"+m;

            Work tmp = new Work(w,time);

        p_arr.add(tmp);
        CustomAdapter adapter;
        adapter = new CustomAdapter(this,R.layout.item_with_title_and_time,p_arr);
        list.setAdapter(adapter);

    }



}
