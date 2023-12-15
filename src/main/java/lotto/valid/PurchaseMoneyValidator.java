package lotto.valid;

import lotto.exception.ErrorMessage;

public class PurchaseMoneyValidator extends InputValidator {

    private static final int LOTTO_PRICE = 1000;
    public static void validate(String money) {
        validateNumber(money, ErrorMessage.INVALID_PURCHASE_MONEY_ERROR.getMessage());
        checkMoneyCanDivide(money);
    }

    private static void checkMoneyCanDivide(String money) {
        if (isMoneyDivideWithThousand(money)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_MONEY_ERROR.getMessage());
        }
    }

    private static boolean isMoneyDivideWithThousand(String money) {
        return Integer.parseInt(money) % LOTTO_PRICE == 0;
    }
}
