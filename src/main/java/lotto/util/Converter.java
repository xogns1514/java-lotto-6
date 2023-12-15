package lotto.util;

import java.util.List;
import java.util.stream.Stream;

public class Converter {

    private static final String COMMA = ",";

    public static List<Integer> convertToIntegerList(String input) {
        return Stream.of(input.split(COMMA))
                .map(Integer::parseInt)
                .toList();
    }

    public static List<String> splitWithComma(String input) {
        return Stream.of(input.split(COMMA))
                .toList();
    }
}
