package com.anamradu.untilholiday;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class HolidayItem implements Serializable{
    public String name;
    public String date;

    HolidayItem(String n, String d) {
        name = n;
        date = d;
    }
}
