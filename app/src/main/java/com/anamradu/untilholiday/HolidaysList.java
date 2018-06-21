package com.anamradu.untilholiday;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HolidaysList extends AppCompatActivity {

    public void OpenAddHolidayActivity(View view) {
        Intent intent = new Intent(HolidaysList.this, AddHoliday.class);
        startActivityForResult(intent,1);
    }

    ListView mHolidayList = null;
    List<String> adapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays_list);

        try {
            HolidaysList.RefreshHolidaysList();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mHolidayList = findViewById(R.id.listView_holidays);
        adapterList = new ArrayList<>();
        final ArrayList<HolidayItem> holidayList = null;
        if(holidayList != null) {
            for (HolidayItem item : holidayList) {
                adapterList.add(item.name + " " + item.date);
            }
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(HolidaysList.this,
                R.layout.list_item, R.id.textView_Holiday, adapterList);
        mHolidayList.setAdapter(adapter);
        mHolidayList.setOnItemClickListener(listOnItemClickListener);
        mHolidayList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                adapterList.remove(view);
                holidayList.remove(position);
                adapter.notifyDataSetChanged();

                return true;
            }
        });
    }

    AdapterView.OnItemClickListener listOnItemClickListener = new AdapterView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Date currentDate = new Date();
            String stringDate = ((HolidayItem)(parent.getItemAtPosition(position))).date;
            Date eventDate = null;
            try {
                eventDate = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long timeLeft = (eventDate.getTime() - currentDate.getTime())/(24*60*60*1000);
            Toast.makeText(HolidaysList.this, timeLeft + " more days until " +
                            ((HolidayItem)(parent.getItemAtPosition(position))).date,
                    Toast.LENGTH_SHORT).show();
        }
    };

    public static void RefreshHolidaysList() throws ParseException {
        for(int cnt=0; cnt<MainActivity.holidayList.size(); cnt++){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date futureDate = dateFormat.parse(MainActivity.holidayList.get(cnt).date);
            Date currentDate = new Date();
            if(currentDate.after(futureDate)){
                MainActivity.holidayList.remove(cnt);
            }
        }
    }
}
