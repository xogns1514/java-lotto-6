package lotto.view;

import java.text.DecimalFormat;
import lotto.domain.LottoStore;

public class OutputView {

    private static final String PURCHASE_QUANTITY = "%d개를 구매했습니다.";
    private static final String MATCH_RANK = "%d개 일치 (%s원) - %d개\n";
    private static final String SECOND_RANK = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";

    private static final String OUTPUT_PROFIT_RATIO= "총 수익률은 %.1f%%입니다.";
    private static final String OUTPUT_MATCH_INTRO = "당첨 통계\n" + "---" + "\n";
    private static final String OUTPUT_DECIMAL_FORMAT = "###,###";

    private static final DecimalFormat formatter = new DecimalFormat(OUTPUT_DECIMAL_FORMAT);


    public static final void outputPurchaseQuantity(int quantity) {
        System.out.printf(PURCHASE_QUANTITY, quantity);
    }

    public static final void outputLottos(LottoStore lottoStore) {
        System.out.printf(lottoStore.toString() + "\n");
    }

    public static final void outputMatchIntro() {
        System.out.printf(OUTPUT_MATCH_INTRO);
    }

    public static final void outputMatchRank(int matchCount, int prize, int count) {
        System.out.printf(MATCH_RANK, matchCount, formatter.format(prize), count);
    }

    public static final void outputSecondRank(int matchCount, int prize, int count) {
        System.out.printf(SECOND_RANK, matchCount, formatter.format(prize), count);
    }

    public static final void outputProfit(double profit) {
        System.out.printf(OUTPUT_PROFIT_RATIO, profit);
    }
}
