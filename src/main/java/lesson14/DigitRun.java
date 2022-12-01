package lesson14;

import java.util.Arrays;
import java.util.Spliterator;

public class DigitRun {
    public static void main(String[] args) {
        Digit[] digits = Digit.createDigits(
                "  @@@      @     @@@@@   @@@@@  @       @@@@@@@  @@@@@  @@@@@@@  @@@@@   @@@@@ ",
                " @   @    @@    @     @ @     @ @    @  @       @     @ @    @  @     @ @     @",
                "@     @  @ @          @       @ @    @  @       @           @   @     @ @     @",
                "@     @    @     @@@@@   @@@@@  @    @  @@@@@@  @@@@@@     @     @@@@@   @@@@@@",
                "@     @    @    @             @ @@@@@@@       @ @     @   @     @     @       @",
                " @   @     @    @       @     @      @  @     @ @     @   @     @     @ @     @",
                "  @@@    @@@@@  @@@@@@@  @@@@@       @   @@@@@   @@@@@    @      @@@@@   @@@@@ "
        );
        int height = digits[0].lines.length;
        if(isNumeric(args[0])){
            int[] number = Arrays.stream(args[0].split("")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < height; i++) {
                for (int digit : number) {
                    System.out.print(digits[digit].lines[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean isNumeric(String string) {
        int intValue;

        System.out.println(String.format("Parsing string: \"%s\"", string));

        if(string == null || string.equals("")) {
            System.out.println("Your string is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input only numbers without space and coma");
        }
        return false;
    }
}
