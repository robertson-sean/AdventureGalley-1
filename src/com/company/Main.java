package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("You have entered a room.");
        String prompt = reader.next();
        while(true) {

            if (prompt.equals("look")) {

                System.out.println("The room is dark");
            }
            else if (prompt.equals("quit")) {
                break;
            }
            else{
                System.out.println("I'm sorry, I don't understand. Please try again: ");
            }
            prompt = reader.next();
        }
    }
}
