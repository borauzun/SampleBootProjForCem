package com.tbuk.psd2.model.common;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DateTime {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public DateTime getDateTime(LocalDateTime dt){
        this.year=dt.getYear();
        this.month=dt.getMonthValue();
        this.day=dt.getDayOfMonth();
        this.hour=dt.getHour();
        this.minute=dt.getMinute();
        this.second=dt.getSecond();

        return this;
    }


}
