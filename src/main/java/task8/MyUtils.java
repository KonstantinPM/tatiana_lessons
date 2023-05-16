package task8;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    private static final Map<Integer, Function<String, String>> NUMBER_LENGTH_TO_CODE_FUNCTION_MAP = Map.of(5, s -> "err",
                                                                                                            7, s -> "loc",
                                                                                                            10, s -> s.substring(0, 3));
    private static final Map<Integer, Function<String, String>> NUMBER_LENGTH_TO_VALUE_FUNCTION_MAP = Map.of(10, s -> s.substring(3));

    public static Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        return list.stream()
                   .flatMap(s -> s)
                   .filter(Objects::nonNull)
                   .map(MyUtils::removeExtraSymbols)
                   .filter(s -> !s.isEmpty())
                   .distinct()
                   .collect(Collectors.toMap(MyUtils::getCodeOfNumber,
                                             number -> Stream.of(getNumberWithoutCode(number)),
                                             (v1, v2) -> Stream.concat(v1, v2).sorted()));
    }

    private static String removeExtraSymbols(String number) {
        return number.replaceAll("[()\\s-]+", "");
    }

    private static String getCodeOfNumber(String number) {
        int numberLength = number.length();
        if (!NUMBER_LENGTH_TO_CODE_FUNCTION_MAP.containsKey(numberLength)) {
            throw new IllegalArgumentException("Unsupported number type: " + number);
        }

        return NUMBER_LENGTH_TO_CODE_FUNCTION_MAP.get(numberLength).apply(number);
    }

    public static String getNumberWithoutCode(String number) {
        return NUMBER_LENGTH_TO_VALUE_FUNCTION_MAP.getOrDefault(number.length(), s -> s).apply(number);
    }
}
