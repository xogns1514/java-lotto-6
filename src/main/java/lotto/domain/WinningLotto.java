package lotto.domain;

import lotto.exception.ErrorMessage;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        if (isBonusNumberDuplicate(lotto, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    private boolean isBonusNumberDuplicate(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
