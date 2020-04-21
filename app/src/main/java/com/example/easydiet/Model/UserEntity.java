package com.example.easydiet.Model;

import androidx.room.ColumnInfo;

import androidx.room.Entity;

import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class UserEntity {

    public UserEntity(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    // first registration
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    // after registration
    private double currentHeight;
    private double currentWeight;
    private double currentBmi;
    private double currentBmr;

    private int priority;

    public void setId(int id) {
        this.id = id;
    }

    public void setCurrentHeight(double currentHeight) {
        this.currentHeight = currentHeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public void setCurrentBmi(double currentBmi) {
        this.currentBmi = currentBmi;
    }

    public void setCurrentBmr(double currentBmr) {
        this.currentBmr = currentBmr;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public double getCurrentHeight() {
        return currentHeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public double getCurrentBmi() {
        return currentBmi;
    }

    public double getCurrentBmr() {
        return currentBmr;
    }

    public int getPriority() {
        return priority;
    }
}
