package com.company;
import java.util.Scanner;

public class Validation {

    public int intValidation()
    {
        Scanner sc = new Scanner(System.in);
        String input;
        boolean valid = false;
        int x = 0;
        input = sc.next();
        do {
            try
            {
                x = Integer.parseInt(input);
                if (x<0)
                {
                    throw new IllegalArgumentException("Enter positive number");
                }
                valid = true;
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Invalid entry. Enter an integer: ");
                input = sc.next();
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
                input = sc.next();
            }
        }while (!valid);
        return x;
    }

    public double doubleValidation()
    {
        Scanner sc = new Scanner(System.in);
        String input;
        boolean valid = false;
        double x = 0;
        input = sc.next();
        do {
            try
            {
                x = Double.parseDouble(input);
                if (x<0)
                {
                    throw new IllegalArgumentException("Enter positive number");
                }
                valid = true;
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Invalid entry. Enter a double: ");
                input = sc.next();
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
                input = sc.next();
            }
        }while (!valid);
        return x;
    }
}
