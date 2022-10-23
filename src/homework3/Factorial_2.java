package homework3;

public class Factorial_2 {
    public static void main(String[] args) {
        int n = 7;
        System.out.println("Factorial " + n + " = " + factorial(n));
    }

    static int factorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = i * factorial;
        }
        return factorial;
    }
}

