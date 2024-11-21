package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {

        private static Scanner entry = new Scanner(System.in);

        public static int readInt(String message) {
            int data = 0;
            boolean dataOk = false;

            while(!dataOk) {
                try {
                    System.out.println(message);
                    data = entry.nextInt();
                    entry.nextLine();
                    dataOk = true;
                } catch(InputMismatchException e) {
                    System.err.println("Format error. Please, try again.");
                    entry.nextLine();
                }
            }
            return data;

        }

        public static String readString(String message) {
            String data = "";
            boolean dataOk = false;

            while(!dataOk) {
                try {
                    System.out.println(message);
                    data = entry.nextLine();
                    dataOk = true;
                } catch (Exception e) {
                    System.err.println("Error. Please, try again.");
                }
            }
            return data;

        }
}
