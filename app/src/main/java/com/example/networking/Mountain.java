package com.example.networking;

public class Mountain {
    private String name;
    private String location;
    private int height;

    public Mountain(String name){
        this.name = name;
    }

    public Mountain(String name, String location, int height){
        this.name = name;
        this.location = location;
        this.height = height;
    }

    public String getName(){
        return name;
    }

}
