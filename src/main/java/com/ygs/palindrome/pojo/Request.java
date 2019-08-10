package com.ygs.palindrome.pojo;


public class Request {

    private String number;

    private int palindromeNum;

    public Request(){

    }

    public Request(String number, int palindromeNum) {
        this.number = number;
        this.palindromeNum = palindromeNum;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPalindromeNum() {
        return palindromeNum;
    }

    public void setPalindromeNum(int polindromeNum) {
        this.palindromeNum = polindromeNum;
    }
}
