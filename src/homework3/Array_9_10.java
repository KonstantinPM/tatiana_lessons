package homework3;

import java.util.Arrays;
import java.util.Scanner;

public class Array_9_10 {
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
        int min = minimum(arr);
        System.out.println("Minimum:");
        for (int h = 0; h < n; h++) {
            if (min == arr[h]) {
                System.out.println(min);
            }
        }
        int max = maximum(arr);
        System.out.println("Maximum:");
        for (int z = 0; z < n; z++) {
            if (max == arr[z]) {
                System.out.println(max);
            }
        }

    }

    static int maximum(int arr[]) {
        int max = arr[0];
        for (int k = 1; k < arr.length; k++) {
            if (max < arr[k]) {
                max = arr[k];
            }
        }
        return max;
    }

    static int minimum(int arr[]) {
        int min = arr[0];
        for (int k = 1; k < arr.length; k++) {
            if (min > arr[k]) {
                min = arr[k];
            }
        }
        return min;
    }
}
