package com.company;
import java.util.Scanner;

public class Reader {
    private Scanner input = new Scanner(System.in);


    public int readInt(String prompt){
        System.out.print(prompt);
        int n = input.nextInt();
        input.nextLine();
        return n;
    }
    public String readLine(String prompt){
        System.out.print(prompt);
        String str = input.nextLine();
        return str;
    }
}
