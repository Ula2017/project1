package com.company;


import java.util.ArrayList;
import java.util.List;

public class Deputy {
    private String name;
    private String deputyID;
    private List<Spending> spendings;

    public Deputy(){
        this.spendings=new ArrayList<>();

    }

    public String getNames(){
        return name;
    }
    public String getID(){
        return deputyID;
    }
    public void addID(String ID){
        this.deputyID=ID;
    }

    public void addName( String name){
        this.name=name;
    }
}
