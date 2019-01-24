package com.basic.algortithms.sectionA;

public class DesignerPdf {
    static int designerPdfViewer(int[] h, String word) {

        //get the ascii values for each letter
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] wordIndexArray = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            //find the alphabet position value
            char letter = word.charAt(i);
            int letterIndex = alphabet.lastIndexOf( letter );
            //match the alphabet letter with the values of h
            wordIndexArray[i] = h[letterIndex];
        }

        //find the hightest letter at the word
        int hightestLetter = 0;
        for (int i = 0; i < wordIndexArray.length; i++) {
            if( wordIndexArray[i] >= hightestLetter) {
                hightestLetter = wordIndexArray[i];
            }
        }
        return word.length() * (hightestLetter);
    }
}
