package homework3;

public class CycleWhile_3 {
    public static void main(String[] args) {
        int i = 1;
        while (i < 99) {
            i = i + 2;
            System.out.println(i);
        }
        System.out.println("_____________");
        int n = 5;
        int factorial = 0;
        int j = 1;
        while (j < n) {
            factorial = j * n;
            j++;
        }
        System.out.println("Factorial " + n + "=" + factorial);
    }
}
