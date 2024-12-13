package org.anik.main;

import org.anik.connection.ConnectionDB;

import java.sql.Connection;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        boolean run = true;
        while(run){
            System.out.println("-----------------------------");
            System.out.println("1. Create Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contact");
            System.out.println("5. Exit");
            System.out.println("-------------------------------");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    run = false;
                    break;
            }
        }
    }
}
