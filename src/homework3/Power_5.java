package homework3;

public class Power_5 {
    public static void main(String[] args) {
        int n = 3;
        int x = 3;
        int result = x;
        for (int i = 0; i < n; i++) {
            result = result * x;
        }
        System.out.println(x + " to the power of " + n + " equals " + result);
        ;
    }
}
