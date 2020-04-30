package com.example.easydiet.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "weight_table")
public class WeightEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private double weight;

    private String date;

    private String day;

    public WeightEntity(double weight, String date, String day) {
        this.weight = weight;
        this.date = date;
        this.day = day;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public String getDate() {
        return date;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

}
