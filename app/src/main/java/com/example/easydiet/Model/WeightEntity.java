package com.example.easydiet.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Time;
import java.util.Date;

@Entity(tableName = "weight_table")
public class WeightEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private double value;

    private Date date;

    private Time time;

    private int priority;

    public WeightEntity(double value) {
        this.value = value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public int getPriority() {
        return priority;
    }
}
