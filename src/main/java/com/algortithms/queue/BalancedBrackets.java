package com.algortithms.queue;

import java.io.*;
import java.util.*;

public class BalancedBrackets {
/*
    // Complete the isBalanced function below.
    static String isBalanced(String s) {

        //Declare an empty stack
        Stack stackParent = new Stack();
        Stack stackCorch = new Stack();
        Stack stackLlave = new Stack();

        //iterate through the String to get every bracket
        for( int i = 0; i< s.length(); i++ ) {

            //if the current char is an opening branch, push the current char
            if( s.charAt(i) == '{' ) {
                stackParent.push( s.charAt(i) );
                //if the current char is a closing branch, pop the current char
            } else if( s.charAt(i) == '}' ) {
                //before poping, check if stack is empty, if so, return "NO"
                if( stackParent.empty() )
                    return "NO";
                if(i > 0 && s.charAt(i-1) != '{'
                        && s.charAt(i-1) != ')'
                        && s.charAt(i-1) != '}'
                        && s.charAt(i-1) != ']' )
                    return "NO";

                stackParent.pop();
            }

            if( s.charAt(i) == '(' ) {
                stackCorch.push( s.charAt(i) );
            } else if( s.charAt(i) == ')' ) {
                if( stackCorch.empty() )
                    return "NO";

                char c = s.charAt(i-1);
                if(i > 0 && s.charAt(i-1) != '('
                        && s.charAt(i-1) != ')'
                        && s.charAt(i-1) != '}'
                        && s.charAt(i-1) != ']')
                    return "NO";

                stackCorch.pop();
            }

            if( s.charAt(i) == '[' ) {
                stackLlave.push( s.charAt(i) );
            } else if( s.charAt(i) == ']' ) {
                if( stackLlave.empty() )
                    return "NO";

                if(i > 0 && s.charAt(i-1) != '['
                        && s.charAt(i-1) != ')'
                        && s.charAt(i-1) != '}'
                        && s.charAt(i-1) != ']')
                    return "NO";

                stackLlave.pop();
            }


        }

        if( stackParent.empty() && stackCorch.empty() && stackLlave.empty() ) {
            System.out.println("\nReturn Yes \n");
            return "YES";
        } else {
            System.out.println("\nReturn NO \n");
            return "NO";
        }
    }
*/
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(isBalanced("{[(])}"));
    }


    static Stack stack = new Stack();

    static boolean mathcingPairs(char popedChar, char currentChar) {
        if(popedChar == '(' && currentChar == ')')
            return true;
        if(popedChar == '[' && currentChar == ']')
            return true;
        if(popedChar == '{' && currentChar == '}')
            return true;
        else
            return false;
    }

    static boolean isBalanced(String s) {
        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }

            if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {

                if(stack.empty())
                    return false;
                else if(! mathcingPairs((char)stack.pop(), s.charAt(i) ) )
                return true;
            }

        }

        if(stack.empty())
            return true;
        else
            return false;

    }
}
