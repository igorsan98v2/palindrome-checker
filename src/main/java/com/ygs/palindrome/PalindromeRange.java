package com.ygs.palindrome;

import java.math.BigInteger;

public class PalindromeRange {
    private PalindromeFinder palindromeFinder;
    private int progress=0;
    private String[] palindromes;
    public PalindromeRange(String palindrome,int rangeNum){

        palindromeFinder =new PalindromeFinder(palindrome);
        palindromes = new String[rangeNum];
        find();
    }
    private void find(){
        while (progress<palindromes.length){
        if(palindromeFinder.isPalindrome()){
            palindromes[progress]=palindromeFinder.getSource();

        }
        else {
            palindromes[progress] = palindromeFinder.getNearnest();
        }

            BigInteger source = new BigInteger(palindromes[progress]).add(new BigInteger("1"));

            palindromeFinder = new PalindromeFinder(source.toString());
            progress++;
        }
    }

    public String[] getPalindromes() {
        return palindromes;
    }
}
