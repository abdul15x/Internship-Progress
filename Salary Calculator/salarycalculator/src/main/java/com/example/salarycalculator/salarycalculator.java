package com.example.demo;
import java.util.Scanner;
public class salarycalculator

{
        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);

            String[] employeeName = new String[5];
            double[] basicSalary = new double[5];
            double[] allowances = new double[5];
            double[] bonus = new double[5];

            double taxPercentage = 10;

            for (int i = 0; i < 5; i++) {

                System.out.println("\nEnter Details of Employee " + (i + 1));

                System.out.print("Employee Name: ");
                employeeName[i] = input.next();

                System.out.print("Basic Salary: ");
                basicSalary[i] = input.nextDouble();

                System.out.print("Allowances: ");
                allowances[i] = input.nextDouble();

                System.out.print("Bonus: ");
                bonus[i] = input.nextDouble();

                double grossSalary = basicSalary[i] + allowances[i] + bonus[i];
                double taxAmount = grossSalary * taxPercentage / 100;
                double netSalary = grossSalary - taxAmount;

                System.out.println("\n============================");
                System.out.println("Employee Salary Slip");
                System.out.println("============================");
                System.out.println("Employee Name : " + employeeName[i]);
                System.out.println("Basic Salary : " + basicSalary[i]);
                System.out.println("Allowances : " + allowances[i]);
                System.out.println("Bonus : " + bonus[i]);
                System.out.println("Gross Salary : " + grossSalary);
                System.out.println("Tax (10%) : " + taxAmount);
                System.out.println("Net Salary : " + netSalary);
                System.out.println("============================");
            }

        }
    }


