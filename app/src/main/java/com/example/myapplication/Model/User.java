package com.example.myapplication.Model;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String surname;
    private int imagePath;

    private List<String> allmessage;

    public User(int id, String name, String surname, int imagePath) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getAllmessage() {
        return allmessage;
    }

    public void setAllmessage(List<String> allmessage) {
        this.allmessage = allmessage;
    }
}
