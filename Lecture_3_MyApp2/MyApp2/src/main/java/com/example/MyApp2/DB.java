package com.example.MyApp2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DB {

    private ArrayList<User> userTable = new ArrayList<>();
    private HashMap<String,String> wordTable = new HashMap<String,String>();

    public DB(){
        wordTable.put("Sachin","A great Batsman");
        wordTable.put("gfg","website");

        userTable.add(new User(1,25,"Ramu"));
        userTable.add(new User(2,35,"Raka"));
    }

    public String search (String word){
        return wordTable.get(word);
    }

    public User getAUser(int id){
        for(User user : userTable){
            if(user.getId()==id) return user;
        }
        System.out.println("Couldn't find the user");
        return null;
    }

    public List<User> getAllUsers(){
        return userTable;
    }

    public boolean addAUser(User user){
        userTable.add(user);
        return true;
    }

    public boolean deleteAUser(int id){
        for(User user : userTable){
            if(user.getId()==id){
                userTable.remove(user);
                return true;
            }
        }
        System.out.println("Couldn't find the user");
        return false;
    }


}
