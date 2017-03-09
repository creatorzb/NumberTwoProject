package com.example.lenovo.numbertwoapp.model;

/**
 * Created by lenovo on 2017/1/9.
 */

public class Person {
    private String name;
    private String url;
    private boolean checkBox;
    private String image;

    public Person(String url, String name, String image ) {
        this.name = name;
        this.image = image;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
