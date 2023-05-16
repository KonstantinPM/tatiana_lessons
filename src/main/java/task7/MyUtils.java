package task7;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class MyUtils {

    public static Stream<String> nameList(Map<String, Stream<String>> map) {
        return map.values()
                  .stream()
                  .flatMap(s -> s)
                  .filter(Objects::nonNull)
                  .map(MyUtils::removeWhitespaces)
                  .filter(s -> !s.isEmpty())
                  .map(MyUtils::toNameStyle)
                  .distinct()
                  .sorted();
    }

    /**
     * Первая буква должна быть большая, остальные маленькие.
     * Метод String::toLowerCase всю строку приводит в нижний регистр
     */
    private static String toNameStyle(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    /**
     * Метод String::trim удаляет пробелы только в начале и в конце. А нужно еще и внутри строки удалить
     */
    private static String removeWhitespaces(String name) {
        return name.replaceAll("\\s", "");
    }
}
