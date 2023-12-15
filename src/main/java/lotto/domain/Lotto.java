package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkValidRange(numbers);
        checkDuplicated(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkValidRange(List<Integer> numbers) {
        if (!isValidNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    private void checkDuplicated(List<Integer> numbers) {
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    private boolean isValidNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isValidRange);
    }

    private boolean isValidRange(int number) {
        return 1 <= number && number <= 45;
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
