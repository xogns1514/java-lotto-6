package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.util.Converter;
import lotto.valid.InputValidator;
import lotto.valid.WinningNumberValidator;
import lotto.valid.PurchaseMoneyValidator;

public class InputView {

    private static final String INPUT_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY);
        String purchaseMoney = Console.readLine();
        PurchaseMoneyValidator.validate(purchaseMoney);
        return Integer.parseInt(purchaseMoney);
    }

    public static List<Integer> inputWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO);
        String winningNumbers = Console.readLine();
        WinningNumberValidator.validate(winningNumbers);
        return Converter.convertToIntegerList(winningNumbers);
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        InputValidator.validateNumber(bonusNumber, ErrorMessage.INVALID_BONUS_NUMBER_ERROR.getMessage());
        return Integer.parseInt(bonusNumber);
    }

}
