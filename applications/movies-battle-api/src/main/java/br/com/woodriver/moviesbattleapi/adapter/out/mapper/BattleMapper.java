package br.com.woodriver.moviesbattleapi.adapter.out.mapper;

import br.com.woodriver.moviesbattleapi.adapter.out.mapper.MovieMapper;
import br.com.woodriver.moviesbattleapi.adapter.out.repository.entity.BattleEntity;
import br.com.woodriver.moviesbattleapi.application.domain.Battle;
import br.com.woodriver.moviesbattleapi.application.domain.Movie;
import org.springframework.data.util.Pair;

public class BattleMapper {

    public static BattleEntity toEntity(Battle battle) {
        if (statusByPair(battle.getCurrentQuestion())) {
            return new BattleEntity(
                    battle.getId(),
                    battle.getScore(),
                    battle.getFailures(),
                    statusByPair(battle.getCurrentQuestion()),
                    MovieMapper.toEntity(battle.getCurrentQuestion().getFirst()),
                    MovieMapper.toEntity(battle.getCurrentQuestion().getSecond())
            );
        } else {
            return new BattleEntity(
                    battle.getId(),
                    battle.getScore(),
                    battle.getFailures(),
                    statusByPair(battle.getCurrentQuestion()),
                    null,
                    null
            );
        }

    }

    public static boolean statusByPair(Pair<Movie,Movie> pair){
        return pair != null;
    }

    public static Battle toDomain(BattleEntity battle) {
            return null;
    }
}
