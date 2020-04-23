package com.example.easydiet.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Time;
import java.util.Date;

@Entity(tableName = "weight_table")
public class WeightEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private double weight;

    private String date;



    public WeightEntity(double weight, String date) {
        this.weight = weight;
        this.date = date;
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

}
