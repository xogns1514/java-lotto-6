package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    LottoService lottoService = new LottoService();


    public void run() {
        int purchaseMoney = InputView.inputPurchaseMoney();
        int quantity = purchaseMoney / 1000;
        LottoStore myLottos = LottoStore.generateLotto(quantity);

        OutputView.outputPurchaseQuantity(quantity);
        OutputView.outputLottos(myLottos);

        List<Integer> numbers = InputView.inputWinningLotto();
        int bonusNumber = InputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(new Lotto(numbers), bonusNumber);

        lottoService.updateMatch(myLottos, winningLotto);
        lottoService.getProfitRatio(purchaseMoney);

        printMatch();
        OutputView.outputProfit(lottoService.getProfitRatio(purchaseMoney));

    }

    private void printMatch() {
        OutputView.outputMatchIntro();
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue;
            List<Integer> information = lottoService.getInformation(rank);
            if (rank == Rank.SECOND) {
                OutputView.outputSecondRank(information.get(0), information.get(1), information.get(2));
                continue;
            }
            OutputView.outputMatchRank(information.get(0), information.get(1), information.get(2));
        }
    }
}
