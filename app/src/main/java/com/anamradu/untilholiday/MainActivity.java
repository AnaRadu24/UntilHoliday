package com.anamradu.untilholiday;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<HolidayItem> holidayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HolidayItem item = new HolidayItem("Saint Maria", "2018-08-15");
        holidayList.add(item);
        item = new HolidayItem("Saint Andrew", "2018-11-30");
        holidayList.add(item);
        item = new HolidayItem("National Day", "2018-12-01");
        holidayList.add(item);
        item = new HolidayItem("Christmas", "2018-12-25");
        holidayList.add(item);
        item = new HolidayItem("2nd Day of Christmas", "2018-12-26");
        holidayList.add(item);
        item = new HolidayItem("New Year", "2019-01-01");
        holidayList.add(item);
        item = new HolidayItem("Unification Day", "2019-01-24");
        holidayList.add(item);
        item = new HolidayItem("Work Day", "2019-05-01");
        holidayList.add(item);
        item = new HolidayItem("Child's Day", "2019-06-01");
        holidayList.add(item);

        try {
            HolidaysList.RefreshHolidaysList();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Button mStartBtn;
        mStartBtn = (Button) findViewById(R.id.button_start);
        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HolidayCountdown.class);
                startActivityForResult(intent, 1);
            }
        });

    }

}
