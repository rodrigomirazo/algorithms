package com.basic.algortithms.sectionC;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Stack;

public class QueueUsingTwoStacks {

    public static Stack input = new Stack();
    public static Stack output = new Stack();

    public static void main(String[] args) {
        /*
            Operation types:
            1 x: Enqueue element  into the end of the queue.
            2: Dequeue the element at the front of the queue.
            3: Print the element at the front of the queue.
        */
        //10:
        //enQueue(input, 0);
        //1 42:
        enQueue(input, 42); // case: {42}
        //2:
        deQueue(input, output);// case: {}
        //1 14:
        enQueue(input, 14);// case: {14}
        //3
        printPeek(input, output);// case: Print {14}
        //1 28
        enQueue(input, 28);// case: {14, 28}
        //3
        printPeek(input, output);
        //1 60
        enQueue(input, 60);
        //1 78
        enQueue(input, 78);
        //2
        deQueue(input, output);
        //2
        deQueue(input, output);
    }

    public static void enQueue(Stack input, int data) {
        input.push(data);
    }

    public static void deQueue(Stack input, Stack output) {
        //check if the output stack is empty
        if(output.empty()) {
            //pop an element from the input Stack & save a temp value
            int popValue = (int) input.pop();
            //push value from input Stack into output
            output.push(popValue);
        }
        //finally pop an element from output Stack
        output.pop();
    }

    public static void printPeek(Stack input, Stack output) {

        //verify if Input Stack is not empty
        if( !input.empty() ) {
            //print only first element
            int peek = -1;
            for(Object element : input)
            {
                peek = (int) element;
                break;
            }
            System.out.println("Front Element = " + peek);
        }
    }

}
