package com.anamradu.untilholiday;

public class DataModel {

    private int mHolidayIcon;
    private String mHolidayName;
    private String mHolidayDate;

    public DataModel(int mHolidayIcon, String mHolidayName, String mHolidayDate) {
        this.mHolidayIcon = mHolidayIcon;
        this.mHolidayName = mHolidayName;
        this.mHolidayDate = mHolidayDate;
    }

    public int getHolidayIcon() {
        return mHolidayIcon;
    }

    public void setHolidayIcon(int mHolidayIcon) {
        this.mHolidayIcon = mHolidayIcon;
    }

    public String getHolidayName() {
        return mHolidayName;
    }

    public void setHolidayName(String mHolidayName) {
        this.mHolidayName = mHolidayName;
    }

    public String getHolidayDate() {
        return mHolidayDate;
    }

    public void setHolidayDate(String mHolidayDate) {
        this.mHolidayDate = mHolidayDate;
    }
}