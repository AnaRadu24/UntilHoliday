package com.anamradu.untilholiday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class HolidaysList extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.holidays_list);
        ArrayList<DataModel> holidaysList = new ArrayList<>();
        holidaysList.add(new DataModel(R.drawable.god_good_job, "My Brithday" , "2018-06-24"));
        holidaysList.add(new DataModel(R.drawable.girl_good_job,"St. Maria","2018-08-15"));
        holidaysList.add(new DataModel(R.drawable.buddha_good_job,"St. Andrew","2018-11-31"));
        holidaysList.add(new DataModel(R.drawable.god_good_job,"National Day","2018-12-01"));
        holidaysList.add(new DataModel(R.drawable.god_good_job,"Christmas","2018-08-15"));
        holidaysList.add(new DataModel(R.drawable.god_good_job,"New Year","2019-01-01"));
        holidaysList.add(new DataModel(R.drawable.god_good_job,"National Unification Day","2019-01-24"));
        holidaysList.add(new DataModel(R.drawable.buddha_good_job,"Easter","2019-04-08"));
        holidaysList.add(new DataModel(R.drawable.boy_good_job,"Work Day","2019-05-01"));
        holidaysList.add(new DataModel(R.drawable.buddha_good_job,"Rusalii","2019-05-28"));
        holidaysList.add(new DataModel(R.drawable.girl_good_job,"Child's Day","2019-06-01"));


        mAdapter = new CustomAdapter(this,holidaysList);
        listView.setAdapter(mAdapter);

    }
}
