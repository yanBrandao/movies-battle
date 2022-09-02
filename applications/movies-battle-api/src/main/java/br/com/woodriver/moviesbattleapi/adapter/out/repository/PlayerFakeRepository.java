package br.com.woodriver.moviesbattleapi.adapter.out.repository;

import br.com.woodriver.moviesbattleapi.application.domain.Battle;
import br.com.woodriver.moviesbattleapi.application.domain.Movie;
import br.com.woodriver.moviesbattleapi.application.domain.Player;
import br.com.woodriver.moviesbattleapi.application.port.out.PlayerRepositoryPort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

@Repository
public class PlayerFakeRepository implements PlayerRepositoryPort {
    @Override
    public Player loadPlayerInformationById(String id) {
        if (Objects.equals(id, "1"))
            return new Player(
                id, "Random Name", new Battle(
                        0, 0, 0, Pair.of(
                                new Movie("A", "A volta dos que não foram","", "", "", BigDecimal.TEN),
                                new Movie("B", "2 Carecas brigando por um pente","", "", "", BigDecimal.ONE)
                ), new HashMap<>()
            )
            );
        else
            return new Player(
                    id, "Random Name", null
            );
    }
}
