package com.tbuk.psd2.model.common;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Date {
    private int year;
    private int month;
    private int day;

    public Date getDate(LocalDate dt){
        this.year=dt.getYear();
        this.month=dt.getMonthValue();
        this.day=dt.getDayOfMonth();

        return this;
    }

}
