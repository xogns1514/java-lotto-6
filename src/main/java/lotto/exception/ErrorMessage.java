package lotto.exception;

public enum ErrorMessage {

    INVALID_BONUS_NUMBER_ERROR("올바르지 않은 보너스 번호입니다."),
    INVALID_PURCHASE_MONEY_ERROR("올바르지 않은 구입금액입니다."),
    INVALID_LOTTO_NUMBER_ERROR("올바르지 않은 로또 숫자입니다.");
    private final String message;
    private final String base = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = base + message;
    }

    public String getMessage() {
        return message;
    }
}
