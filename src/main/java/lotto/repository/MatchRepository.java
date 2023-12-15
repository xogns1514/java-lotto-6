package lotto.repository;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Rank;

public class MatchRepository {

    private static final Map<Rank, Integer> repository = new EnumMap<>(Rank.class);

    public MatchRepository() {
        throw new IllegalStateException("MatchRepository");
    }

    public void saveMatch(Rank rank) {
        repository.put(rank, repository.getOrDefault(rank, 0) + 1);
    }

    public int getMatchRankCount(Rank rank) {
        return repository.get(rank);
    }

}
