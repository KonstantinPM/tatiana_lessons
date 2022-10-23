package homework3;

import java.util.Arrays;
import java.lang.*;

public class Array_8 {
    public static void main(String[] args) {
        int[] arrOfOdd = new int[10];
        for (int i = 0; i < 10; i++) {
            arrOfOdd[i] = 2 * i + 1;
        }
        System.out.print(Arrays.toString(arrOfOdd));
    }
}
