package homework3;

public class DoWhile_4 {
    public static void main(String[] args) {
        int i = 1;
        do {
            System.out.println(i);
            i = i + 2;
        }
        while (i <= 100);
        System.out.println("________________");
        int n = 5;
        System.out.println("Factorial " + n + "=" + factorialDoWhile(n));
    }

    static int factorialDoWhile(int n) {
        int factorial = 1;
        int j = 1;
        do {
            factorial = factorial * j;
            j++;
        }
        while (j <= n);
        return factorial;
    }
}
