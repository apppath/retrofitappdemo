package com.example.basicprogramming.retrofitappdemo.model;

import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("id")
    private int id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("email")
    private String emailId;
    @SerializedName("age")
    private int age;

    public Users(String firstName, String lastName, String emailId, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public int getAge() {
        return age;
    }

}
