package com.example.demo;
import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        char operator = input.next().charAt(0);

        System.out.print("Enter Second Number: ");
        double num2 = input.nextDouble();

        double result;


        if (operator == '+') {
            result = num1 + num2;
        }
        else if (operator == '-') {
            result = num1 - num2;
        }
        else if (operator == '*') {
            result = num1 * num2;
        }
        else if (operator == '/') {
            if (num2 == 0) {
                System.out.println("Error: Division by zero is not allowed.");
                input.close();
                return;
            }
            result = num1 / num2;
        }
        else {
            System.out.println("Invalid operator.");
            input.close();
            return;
        }


        System.out.println("Answer = " + result);

        input.close();
    }
}