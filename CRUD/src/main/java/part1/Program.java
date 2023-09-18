/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part1;

import java.util.Scanner;

/**
 *
 * @author integ
 */
public class Program {
     public static Scanner scanner = new Scanner(System.in);

    public static String readString(String message, String error) {
        String string;
        while (true) {
            System.out.println(message);
            string = scanner.nextLine();
            if (string.trim().isEmpty()) {
                System.out.println(error);
                continue;
            }
            break;
        }
        return string;
    }
}
