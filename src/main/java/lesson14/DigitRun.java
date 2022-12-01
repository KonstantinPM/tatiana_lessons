package lesson14;

import java.util.Arrays;

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
        for (int j = 0; j < args.length; j++) {
            isDigit(args[j]);
        }
        int[] number = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < height; i++) {
            for (int digit : number) {
                System.out.print(digits[digit].lines[i] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
