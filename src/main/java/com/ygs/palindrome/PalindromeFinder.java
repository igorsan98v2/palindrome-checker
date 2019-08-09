package com.ygs.palindrome;

import java.math.BigInteger;
import java.util.Arrays;

public class PalindromeFinder {
    private String source;
    private char[] check;//need for checking
    private String palindrome;
    private StringBuilder fHalf; /*first half of palindrome*/
    private StringBuilder sHalf; /*second hald of palindrome*/
    public PalindromeFinder(String source){
        this.source = source;
        this.check = source.toCharArray();
        isPalindrome();
        palindrome= findClosest();
    }
    private String findClosest(){
        int length = source.length();
        if(length==1){
            int i = Integer.parseInt(source)+1;
            return source;
        }

        if(all9Case()){
            BigInteger integer = new BigInteger(source).add(new BigInteger("2"));
            return integer.toString();
        }
        char middleChar='N';
        sHalf = new StringBuilder(fHalf).reverse();
        StringBuilder mirroredPalindrome  = null;
        StringBuilder incrisedPalindrome  = null;
        StringBuilder tempFHalf = null;
        StringBuilder tempSHalf = null;
        if(length%2!=0){
            middleChar = check[length/2];
            mirroredPalindrome = new StringBuilder().append(fHalf).append(middleChar).append(sHalf);
            int middleInt = CToI (middleChar);


            if (middleChar == '9')
            {
                tempFHalf = new StringBuilder().append(carryOperation(fHalf.toString().toCharArray(), 1));
                tempSHalf = new StringBuilder(tempFHalf).reverse();

                incrisedPalindrome =new StringBuilder().append(tempFHalf)
                        .append('0').append(tempSHalf);
            }
            else
                incrisedPalindrome = new StringBuilder().append(fHalf).append(middleInt+1).append(sHalf);//was middleChar+1
        }
        else {
            int l = fHalf.length();
            tempFHalf =new StringBuilder(fHalf);
            mirroredPalindrome =new StringBuilder(fHalf).append(sHalf);

            tempFHalf =new StringBuilder(fHalf);
            if (fHalf.charAt(l - 1) == '9')
                tempFHalf =new StringBuilder().append(carryOperation(fHalf.toString().toCharArray(), 1));
            else
                tempFHalf.setCharAt(l - 1, IToC(CToI(tempFHalf.charAt(l - 1)) + 1));

            tempSHalf =new StringBuilder(tempFHalf).reverse();

            incrisedPalindrome =new StringBuilder(tempFHalf).append(tempSHalf);
        }
        /*@TODO need to be refactored */
        StringBuilder [] test = {mirroredPalindrome,incrisedPalindrome};
        long num = Long.parseLong(source);

        long[] testArr = new long[2];
        for (int i=0;i<2;i++){

            long candidate = stringToNum(test[i]);

            testArr[i] = candidate-num;
        }
        Arrays.sort(testArr);
        long finalCandidate =0;
        for(int i=0;i<2;i++){

            if(testArr[i]>0)
                return (String.valueOf((testArr[i])+num));
        }
        return null;
    }
    private long stringToNum (StringBuilder stringBuilder){
        return Long.parseLong(stringBuilder.toString());
    }

    // Add carry to the number of given size
    private char[] carryOperation(char[] num, int carry)
    {
        int length = num.length;
        System.out.println("before"+ new StringBuilder().append(num));
        if (carry == -1)
        {
            int i = length - 1;
            while (i >= 0 && num[i] == '0')
                num[i--] = '9';
            if (i >= 0)
                num[i] = IToC(CToI(num[i]) - 1);
        }
        else
        {
            for (int i = length - 1; i >= 0; i--)
            {
                int digit = CToI(num[i]);
                num[i] = IToC((digit + carry) % 10);
                carry = (digit + carry) / 10;

            }
        }
        System.out.println("after"+new StringBuilder().append(num));
        return num;
    }
    /*char to int function*/
    public int CToI(char x){
        return x-'0';
    }
    /*int to char function*/
    public char IToC(int x){
        return (char)(x+'0');
    }

    public boolean all9Case(){
        for(int i=0;i<check.length;i++) {
            if(check[i]!='9'){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(){
        return isPalindrome(source);
    }
    public boolean isPalindrome(String candidate){
        int length = candidate.length();
        if(length==1) return  true;
        String firstSubstring,secondSubsting;
        //let`s check. Is this polinrome contains odd or even number of digit`s
        if(length%2==0){
            firstSubstring = candidate.substring(0,length/2);
            secondSubsting = candidate.substring(length/2,length);
        }
        else {
             firstSubstring = candidate.substring(0,length/2);
             secondSubsting = candidate.substring(length/2+1,length);

        }
        fHalf = new StringBuilder(firstSubstring);
        sHalf = new StringBuilder(secondSubsting).reverse();
        secondSubsting =sHalf.toString();

        return firstSubstring.equals(secondSubsting);
    }
    public String getNearnest(){
        return palindrome;
    }

    public String getSource() {
        return source;
    }
}
