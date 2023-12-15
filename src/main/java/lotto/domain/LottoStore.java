package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {

    private List<Lotto> lottos;

    public LottoStore(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoStore generateLotto(int quantity) {
        List<Lotto> lottoStore = new ArrayList<>();
        for (int count = 0; count < quantity; count++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottoStore.add(new Lotto(numbers));
        }
        return new LottoStore(lottoStore);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.getNumbers().toString());
            sb.append(" \n");
        }
        return sb.toString().trim();
    }
}
