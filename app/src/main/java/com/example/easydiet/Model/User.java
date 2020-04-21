package com.example.easydiet.Model;

import androidx.room.ColumnInfo;

import androidx.room.Entity;

import androidx.room.PrimaryKey;

@Entity
public class User {

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    // first registration
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    // after registration
    private double currentHeight;
    private double currentWeight;
    private double currentBmi;
    private double currentBmr;



}
