package homework10;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        double a;
        double b;
        double c;
        System.out.println("Example ax^2 + bx + c = 0");
        System.out.println("Input a, b, c:");
        Scanner sc = new Scanner(System.in);
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        quadratic(a,b,c);

    }
    public static boolean quadratic (double a, double b, double c){
        double diskreminant;
        diskreminant = (b * b) - (4 * a * c);
        if (diskreminant>0){
            double x1 = (-b - Math.sqrt(diskreminant))/(2*a);
            double x2 = (-b + Math.sqrt(diskreminant))/(2*a);
            System.out.println("Answer: X1 = "+x1+" X2 = "+x2);
        }else if (diskreminant==0){
            double x = -b/(2*a);
            System.out.println("Answer = "+x);
        }else {
            System.out.println("There is no answer");
        }
            return true;
    }

}
