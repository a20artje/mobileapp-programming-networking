package com.example.networking;

public class RecyclerViewItem {

    private String name;
    private String location;
    private int height;

    public RecyclerViewItem(String name){
        this.name = name;
    }

    public RecyclerViewItem(String name, String location, int height){
        this.name = name;
        this.location = location;
        this.height = height;
    }


    public String getTitle(){
        return name;
    }

    public void setTitle(String name){
        this.name = name;
    }
}
