package homework3;

public class DoWhile_4 {
    public static void main(String[] args) {
        int i = 1;
        do {
            System.out.println(i);
            ;
            i = i + 2;
        }
        while (i <= 100);
        System.out.println("________________");
        int n = 5;
        int factorial = 0;
        int j = 1;
        do {
            factorial = j * n;
            j++;
        }
        while (j < n);
        System.out.println("Factorial " + n + "=" + factorial);
        ;
    }
}
