package com.ygs.palindrome.pojo;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

import java.util.ArrayList;

@Document(collection = "users", schemaVersion= "1.0")
public class User {
    @Id
    private String username;

    private ArrayList<Request> requests;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }

    public User() {

    }
}
