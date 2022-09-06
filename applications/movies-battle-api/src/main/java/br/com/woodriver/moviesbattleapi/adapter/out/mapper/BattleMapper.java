package br.com.woodriver.moviesbattleapi.adapter.out.mapper;

import br.com.woodriver.moviesbattleapi.adapter.out.mapper.MovieMapper;
import br.com.woodriver.moviesbattleapi.adapter.out.repository.entity.BattleEntity;
import br.com.woodriver.moviesbattleapi.application.domain.Battle;
import br.com.woodriver.moviesbattleapi.application.domain.Movie;
import br.com.woodriver.moviesbattleapi.application.domain.Player;
import org.springframework.data.util.Pair;

public class BattleMapper {

    public static BattleEntity toEntity(Battle battle, Player player) {
        if (statusByPair(battle.getCurrentQuestion())) {
            return new BattleEntity(
                    battle.getId(),
                    battle.getScore(),
                    battle.getFailures(),
                    statusByPair(battle.getCurrentQuestion()),
                    MovieMapper.toEntity(battle.getCurrentQuestion().getFirst()),
                    MovieMapper.toEntity(battle.getCurrentQuestion().getSecond()),
                    PlayerMapper.toEntity(player)
            );
        } else {
            return new BattleEntity(
                    battle.getId(),
                    battle.getScore(),
                    battle.getFailures(),
                    statusByPair(battle.getCurrentQuestion()),
                    null,
                    null,
                    PlayerMapper.toEntity(player)
            );
        }

    }

    public static boolean statusByPair(Pair<Movie,Movie> pair){
        return pair != null;
    }

    public static Battle toDomain(BattleEntity battle) {
            return new Battle(
                    battle.getId(), battle.getScore(),
                    battle.getFailures(), battle.isActive(),
                    Pair.of(
                            MovieMapper.toDomain(battle.getFirstOption()),
                            MovieMapper.toDomain(battle.getSecondOption())),
                    null
            );
    }
}
