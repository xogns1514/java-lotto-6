package lotto.valid;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.util.Converter;

public class NumberValidator extends InputValidator {

    public static void validate(String input) {
        List<String> numbers = Converter.splitWithComma(input);
        numbers.forEach(number ->
                validateNumber(number, ErrorMessage.INVALID_LOTTO_NUMBER_ERROR.getMessage()));
    }


}
