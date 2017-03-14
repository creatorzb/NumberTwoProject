package com.example.lenovo.numbertwoapp.model;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/1/15.
 */

public class User implements Serializable {
    private String name;
    private String number;
    private boolean CheckBox;
    private int image;
    private int cs;

    public int getCs() {
        return cs;
    }

    public void setCs(int cs) {
        this.cs = cs;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isCheckBox() {
        return CheckBox;
    }

    public void setCheckBox(boolean checkBox) {
        CheckBox = checkBox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User(String name, String number , int image, int cs) {
        this.name = name;
        this.number = number;
        this.image=image;
        this.cs=cs;
    }

    public User() {
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", CheckBox=" + CheckBox +
                ", image=" + image +
                ", cs=" + cs +
                '}';
    }
}
