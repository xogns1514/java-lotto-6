package lotto.exception;

public enum ErrorMessage {

    BONUS_NUMBER_DUPLICATE_ERROR("보너스 번호와 로또 번호는 중복될 수 없습니다.");

    private final String message;
    private final String base = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = base + message;
    }

    public String getMessage() {
        return message;
    }
}
