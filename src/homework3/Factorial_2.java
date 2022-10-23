package homework3;

public class Factorial_2 {
    public static void main(String[] args) {
        int n = 7;
        int factorial = 0;
        for (int i = 1; i < n; i++) {
            factorial = i * n;
        }
        System.out.println("Factorial " + n + "=" + factorial);
    }
}
