package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {

    NONE("없음", 0, false, 0),
    FIRST("1등", 6, false, 2_000_000_000),
    SECOND("2등", 5, true, 30_000_000),
    THIRD("3등", 5, false, 1_500_000),
    FOURTH("4등", 4, false, 50_000),
    FIFTH("5등", 3, false, 5000);

    private final String ranking;
    private final int matchNumber;
    private final boolean isBonusNumberMatch;
    private final int prize;


    Rank(String ranking, int matchNumber, boolean isBonusNumberMatch, int prize) {
        this.ranking = ranking;
        this.matchNumber = matchNumber;
        this.isBonusNumberMatch = isBonusNumberMatch;
        this.prize = prize;
    }

    public static Rank findRank(Lotto lotto, WinningLotto winningLotto) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchNumber == getMatchNumberCount(lotto, winningLotto))
                .filter(rank -> rank.isBonusNumberMatch == hasBonusNumber(lotto, winningLotto))
                .findAny()
                .orElse(Rank.NONE);
    }

    private static int getMatchNumberCount(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> myNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();

        return (int) myNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static boolean hasBonusNumber(Lotto lotto, WinningLotto winningLotto) {
        int bonusNumber = winningLotto.getBonusNumber();
        return lotto.getNumbers().contains(bonusNumber);
    }

    public String getRanking() {
        return ranking;
    }

    public int getPrize() {
        return prize;
    }
}
