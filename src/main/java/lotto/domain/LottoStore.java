package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoStore {

    private List<Lotto> lottos;

    public LottoStore(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void generateLotto(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < quantity; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
