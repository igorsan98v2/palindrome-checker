package com.ygs.palindrome;

import com.ygs.palindrome.pojo.PalindromeCollection;
import com.ygs.palindrome.pojo.Request;
import com.ygs.palindrome.pojo.User;
import io.jsondb.JsonDBTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
    final static String dbFilesLocation = "./resources/db";
    final static String baseScanPackage ="com.ygs.palindrome.pojo";
    public static void main() {

        JsonDBTemplate jsonDBTemplate = new JsonDBTemplate(dbFilesLocation,baseScanPackage);
        User user =  new User();
        user.setUsername("potatohead");
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request("3431",10));
        user.setRequests(requests);
        PalindromeRange palindromeRange = new PalindromeRange("3431",10);
        ArrayList<String> arrayList=new ArrayList<String>(Arrays.asList(palindromeRange.getPalindromes()));
        PalindromeCollection collection= new PalindromeCollection(arrayList.get(0),arrayList);
        if (!jsonDBTemplate.collectionExists(User.class))
            jsonDBTemplate.createCollection(User.class);
        if(!jsonDBTemplate.collectionExists(PalindromeCollection.class))
            jsonDBTemplate.createCollection(PalindromeCollection.class);

        jsonDBTemplate.upsert(user);
        jsonDBTemplate.upsert(collection);
        User userFromBd =   jsonDBTemplate.findById("potatohead",User.class);
        System.out.println(userFromBd.getUsername());
    }
}
