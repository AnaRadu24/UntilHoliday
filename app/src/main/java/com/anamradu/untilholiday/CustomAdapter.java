package com.anamradu.untilholiday;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<DataModel> {

    private Context mContext;
    private List<DataModel> holidaysList = new ArrayList<>();

    public CustomAdapter(@NonNull Context context, ArrayList<DataModel> list) {
        super(context, 0 , list);
        mContext = context;
        holidaysList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        DataModel currentHoliday = holidaysList.get(position);

        ImageView image = (ImageView)listItem.findViewById(R.id.imageView_HolidayIcon);
        image.setImageResource(currentHoliday.getHolidayIcon());

        TextView name = (TextView) listItem.findViewById(R.id.textView_HolidayName);
        name.setText(currentHoliday.getHolidayName());

        TextView release = (TextView) listItem.findViewById(R.id.textView_HolidayDate);
        release.setText(currentHoliday.getHolidayDate());

        return listItem;
    }
}
