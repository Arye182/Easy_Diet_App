/*
 * Copyright (c) 2020 Arye182
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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
