package br.com.woodriver.moviesbattleapi.adapter.out.mapper;

import br.com.woodriver.moviesbattleapi.adapter.out.repository.entity.BattleEntity;
import br.com.woodriver.moviesbattleapi.adapter.out.repository.entity.PlayerEntity;
import br.com.woodriver.moviesbattleapi.application.domain.Player;

import java.util.List;
import java.util.Optional;

public class PlayerMapper {
    public static Player toDomain(PlayerEntity playerEntity) {
        return new Player(
                playerEntity.getId(),
                playerEntity.getName(),
                playerEntity.getBattles().stream().map(BattleMapper::toDomain).toList()
        );
    }

    private static BattleEntity activeBattleSession(List<BattleEntity> battles) {
        Optional<BattleEntity> battle = battles.stream().findFirst().filter(BattleEntity::isActive);
        return battle.orElse(null);
    }

    public static PlayerEntity toEntity(Player player) {
        return new PlayerEntity(
                player.getId(),
                player.getName(),
                player.getBattleSession().stream().map(battle -> BattleMapper.toEntity(battle, player)).toList()
        );
    }
}
