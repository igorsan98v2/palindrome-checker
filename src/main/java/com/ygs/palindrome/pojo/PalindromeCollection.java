package com.ygs.palindrome.pojo;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/*simple POJO class for db*/

@Document(collection = "palindromes", schemaVersion= "1.0")
public class PalindromeCollection {
    @Id
    private String id ;
    private ArrayList<String> palindromes;
    private String lastPalindrome;
    private int palindromesNum;


    public PalindromeCollection(){

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPalindromes(ArrayList<String> palindromes) {
        this.palindromes = palindromes;
        updateLastEl();
    }

    public PalindromeCollection(String id, ArrayList<String> palindromes) {
        this.id = id;
        this.palindromes = palindromes;
        updateLastEl();
    }

    public ArrayList<String> getPalindromes() {
        return palindromes;
    }
    public void addPalindrome(String palindrome){
        this.palindromes.add(palindrome);
        updateLastEl();
    }
    public void addPalindromes(List<String> palindromes){
        this.palindromes.addAll(palindromes);
        updateLastEl();
    }
    private void updateLastEl(){
        int size  = this.palindromes.size();
        this.lastPalindrome = this.palindromes.get(size-1);
        this.palindromesNum = size;
    }

    public String getLastPalindrome() {
        return lastPalindrome;
    }

    public int getPalindromesNum() {
        return palindromesNum;
    }

    public void setLastPalindrome(String lastPalindrome) {
        this.lastPalindrome = lastPalindrome;
    }

    public void setPalindromesNum(int palindromesNum) {
        this.palindromesNum = palindromesNum;
    }
}
