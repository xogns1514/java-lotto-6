package lotto.domain;

import lotto.exception.ErrorMessage;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        checkDuplicate(lotto, bonusNumber);
        checkBonusNumber(bonusNumber);
    }

    private void checkDuplicate(Lotto lotto, int bonusNumber) {
        if (isBonusNumberDuplicate(lotto, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_ERROR.getMessage());
        }
    }

    private void checkBonusNumber(int bonusNumber) {
        if (isValidBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_ERROR.getMessage());
        }
    }

    private boolean isBonusNumberDuplicate(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private boolean isValidBonusNumber(int bonusNumber) {
        return 1 <= bonusNumber && bonusNumber <= 45;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
