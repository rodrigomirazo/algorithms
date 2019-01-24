package com.basic.algortithms.sectionC;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBrackets {

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

        if( stackParent.empty() || stackCorch.empty() || stackLlave.empty() ) {
            System.out.println("\nReturn Yes \n");
            return "YES";
        } else {
            System.out.println("\nReturn NO \n");
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
