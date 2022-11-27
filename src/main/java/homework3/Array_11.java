package homework3;

import java.util.Arrays;
import java.util.Scanner;

public class Array_11 {
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
        int max = arr[0];
        int numberOfElement1 = 0;
        for (int k = 1; k < arr.length; k++) {
            if (max < arr[k]) {
                max = arr[k];
                numberOfElement1 = k;
            }
        }
        int min = arr[0];
        int numberOfElement2 = 0;
        for (int k = 1; k < arr.length; k++) {
            if (min > arr[k]) {
                min = arr[k];
                numberOfElement2 = k;
            }
        }
        arr[numberOfElement1] = min;
        arr[numberOfElement2] = max;
        System.out.print(Arrays.toString(arr));
    }
}
