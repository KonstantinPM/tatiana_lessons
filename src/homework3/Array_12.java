package homework3;

import java.util.Arrays;
import java.util.Scanner;

public class Array_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ((int) (Math.random() * 75) - 15);
        }
        System.out.print(Arrays.toString(arr));
        System.out.println();
        System.out.println("Arithmetic mean of an array = " + arithmetic(arr));
    }

    static double arithmetic(int arr[]) {
        double sum = 0;
        for (int j = 0; j < arr.length; j++) {
            sum = sum + arr[j];
        }
        return sum / arr.length;
    }
}
