package homework3;

import java.util.Arrays;
import java.util.Scanner;

public class Array_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input size of array");
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i=0; i<n; i++){
            arr [i] = ((int)(Math.random()*75)-15);
        }
        System.out.print(Arrays.toString(arr));
        System.out.println();
        System.out.println("_____________");
        int min = arr[0];
        int counter = 0;
        for (int j=1; j<n; j++){
            if (min>=arr[j]) {
                   min = arr[j];
            }
     //       if (min==a)
        }
        for (int c=0; c<=counter;c++){
            System.out.println(min);
        }
    }
}
