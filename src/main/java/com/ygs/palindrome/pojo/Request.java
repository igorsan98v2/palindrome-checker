package com.ygs.palindrome.pojo;


public class Request {

    private String number;

    private int polindromeNum;

    public Request(){

    }

    public Request(String number, int polindromeNum) {
        this.number = number;
        this.polindromeNum = polindromeNum;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPolindromeNum() {
        return polindromeNum;
    }

    public void setPolindromeNum(int polindromeNum) {
        this.polindromeNum = polindromeNum;
    }
}
