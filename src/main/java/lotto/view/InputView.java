package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.valid.InputValidator;
import lotto.valid.PurchaseMoneyValidator;

public class InputView {

    public static int inputPurchaseMoney() {
        String purchaseMoney = Console.readLine();
        PurchaseMoneyValidator.validate(purchaseMoney);
        return Integer.parseInt(purchaseMoney);
    }

}
