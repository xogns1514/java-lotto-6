package lotto.repository;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Rank;

public class MatchRepository {

    private static final Map<Rank, Integer> repository = new EnumMap<>(Rank.class);

    public MatchRepository() {
    }

    public void saveMatch(Rank rank) {
        repository.put(rank, repository.getOrDefault(rank, 0) + 1);
    }

    public int getMatchRankCount(Rank rank) {
        if (repository.get(rank) == null) {
            return 0;
        }
        return repository.get(rank);
    }

}
