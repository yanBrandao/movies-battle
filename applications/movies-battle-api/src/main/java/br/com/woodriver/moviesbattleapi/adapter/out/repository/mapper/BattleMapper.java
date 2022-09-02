package br.com.woodriver.moviesbattleapi.adapter.out.repository.mapper;

import br.com.woodriver.moviesbattleapi.adapter.out.repository.entity.BattleEntity;
import br.com.woodriver.moviesbattleapi.application.domain.Battle;

public class BattleMapper {

    public static BattleEntity toEntity(Battle battle) {
        return new BattleEntity(
                battle.getId(),
                battle.getScore(),
                battle.getFailures()
        );
    }
}
