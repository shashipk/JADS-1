package com.example.MyApp1;

import java.util.HashMap;

public class DB {

    HashMap<String, String> dataStore =
            new HashMap<>();

    public DB(){
        dataStore.put("Sachin","A great Batsman");
        dataStore.put("Rahul","A good man");
        dataStore.put("gfg","good for coding" );
    }

    public String search(String word){
        return dataStore.get(word);
    }


}
