package com.anamradu.untilholiday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddHoliday extends AppCompatActivity {

    EditText editHolidayName = null;
    EditText editHolidayDate = null;
    Button mAddHolidayBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_holiday);

        editHolidayName = findViewById(R.id.editHolidayName);
        editHolidayDate = findViewById(R.id.editHolidayDate);
        mAddHolidayBtn = findViewById(R.id.button_add_holiday);

        mAddHolidayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validate()) {
                    HolidayItem item = null;
                    item.name = editHolidayName.getText().toString();
                    item.date = editHolidayDate.getText().toString();
                    HolidayItem currentItem = null;
                    for(int cnt=0; cnt<MainActivity.holidayList.size(); cnt++) {
                        currentItem  = MainActivity.holidayList.get(cnt);
                        if(item.date.compareTo(currentItem.date)>0){
                            for(int pos=MainActivity.holidayList.size(); pos>=cnt; pos--){
                                currentItem  = MainActivity.holidayList.get(pos);
                                MainActivity.holidayList.add(pos+1, currentItem);
                            }
                            MainActivity.holidayList.add(cnt, item);
                            Intent intent = new Intent(AddHoliday.this, HolidaysList.class);
                            startActivityForResult(intent,1);
                        }
                    }
                }
                finish();
            }
        });
    }

    private boolean Validate() {
        if (editHolidayName.getText().toString().trim().equals("")) {
            Toast.makeText(AddHoliday.this, "Invalid Holiday Name",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        if (editHolidayDate.getText().toString().trim().equals("")) {
            Toast.makeText(AddHoliday.this, "Invalid Holiday Name",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date holidayDate = null;
        Date currentDate = new Date();
        try {
            holidayDate = format.parse(editHolidayDate.getText().toString());
        } catch (ParseException e) {
            if (editHolidayDate.getText().toString().trim().equals("")) {
                Toast.makeText(AddHoliday.this, "Invalid Holiday Date",
                        Toast.LENGTH_LONG).show();
                e.printStackTrace();
                return false;
            }
        }
        if (holidayDate.compareTo(currentDate) <= 0) {
            Toast.makeText(AddHoliday.this, "Date is in the past",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}