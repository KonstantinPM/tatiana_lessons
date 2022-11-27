package homework3;

import java.util.Scanner;

public class MultiplicationTable_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer");
        int x = sc.nextInt();
        System.out.println("Multiplication table for " + x + ":");
        System.out.println(1 * x + " " + 2 * x + " " + 3 * x + " " + 4 * x + " " + 5 * x + " " + 6 * x + " " + 7 * x + " " + 8 * x + " " + 9 * x + " " + x * 10);
    }
}
