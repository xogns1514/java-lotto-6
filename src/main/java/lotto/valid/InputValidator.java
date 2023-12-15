package lotto.valid;

import java.util.regex.Pattern;

public class InputValidator {


    private static final String REGEX = "^\\d+$";

    static void validateNumber(String input, String errorMessage) {
        checkInputEmpty(input, errorMessage);
        checkInputIsNumeric(input, errorMessage);
    }

    private static void checkInputEmpty(String input, String errorMessage) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void checkInputIsNumeric(String input, String errorMessage) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean isNumeric(String input) {
        return Pattern.matches(REGEX, input);
    }

}
