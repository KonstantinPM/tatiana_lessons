package lesson14;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Digit {
    String[] lines;

    public Digit(String... lines) {
        this.lines = lines;
    }

    public static Digit[] createDigits(String... lines) {
        int width = (lines[0].length() - 9) / 10;
        return IntStream
                .range(0, 10)
                .mapToObj(digit ->
                        new Digit(Stream.of(lines).map(line -> line.substring(digit * (width + 1), (digit + 1) * (width + 1) - 1))
                                .toArray(String[]::new))).toArray(Digit[]::new);
    }
}


