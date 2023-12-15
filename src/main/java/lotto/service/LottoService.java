package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.repository.MatchRepository;

public class LottoService {

    private final MatchRepository matchRepository = new MatchRepository();
    private static final int RATIO = 100;

    public double getProfitRatio(int purchaseMoney) {
        int totalPrize = getTotalPrize();
        return ((double) totalPrize / purchaseMoney) * RATIO;
    }

    private int getTotalPrize() {
        return Arrays.stream(Rank.values())
                .mapToInt(rank -> matchRepository.getMatchRankCount(rank) * rank.getPrize())
                .sum();
    }

    public void updateMatch(LottoStore myLottos, WinningLotto winningLotto) {
        List<Lotto> lottos = myLottos.getLottos();

        List<Rank> rank = lottos.stream()
                .map(lotto -> Rank.findRank(lotto, winningLotto))
                .toList();
        rank.forEach(matchRepository::saveMatch);
    }
}
