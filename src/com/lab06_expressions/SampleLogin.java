package com.lab06_expressions;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Simple user logging program.
 * Login: must contain only letters, at least 5.
 * Password: can contain letters, numbers, and underscores. At least 6 characters.
 */
public class SampleLogin {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String login;
        String password;

        Pattern logPat = Pattern.compile("[a-zA-Z]{5}[a-zA-Z]*");
        Pattern passPat = Pattern.compile("\\w{6}\\w*");

        while (true) {
            System.out.println("Enter login:");
            login = scan.next();
            System.out.println("Enter password:");
            password = scan.next();

            if (logPat.matcher(login).matches() && passPat.matcher(password).matches()) {
                System.out.println("Welcome");
                break;
            } else {
                System.out.println("Error\n");
            }
        }
    }
}
