package com.example.pracbldfire;

public class MainModel {

    String name,blood,location,contact;
    MainModel(){

    }
    public MainModel(String name,String blood,String location,String contact) {
        this.name = name;
        this.blood=blood;
        this.location=location;
        this.contact=contact;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
