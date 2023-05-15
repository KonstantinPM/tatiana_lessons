package task6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    public static Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        Map<String, List<String>> resultMap = new HashMap<>();

        for (Stream<String> stream : list) {
            stream.flatMap(s -> Arrays.stream(s.split("\\s+")))
                    .map(s -> s.replaceAll("[()-]", "").replaceAll("\\s+", ""))
                    .filter(s -> !s.isEmpty())
                    .distinct()
                    .forEach(phoneNumber -> {
                        String networkCode = getNetworkCode(phoneNumber);
                        resultMap.computeIfAbsent(networkCode, k -> new ArrayList<>()).add(phoneNumber);
                    });
        }

        return resultMap.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream().sorted()));
    }

    private static String getNetworkCode(String phoneNumber) {
        if (phoneNumber.length() >= 3) {
            return phoneNumber.substring(0, 3);
        }
        return "err";
    }
}
