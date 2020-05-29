package com.algortithms;

public class ReverseArray {
    public static void main(String[] args) {
        String str = findEncryptedWord("facebook");
        System.out.println("Result = " + str);
    }

    static String findEncryptedWord(String s) {
        // Write your code here
        if(s.isEmpty())
            return "";


        //get middle char
        int middleIndx = ( s.length() -1 )/ 2;
        String middleChar = s.charAt(middleIndx)+"";

        String partA = findEncryptedWord(s.substring(0, middleIndx));
        String b = s.substring(middleIndx + 1);
        String partB = findEncryptedWord(b);

        return middleChar + partA + partB;
    }

}
