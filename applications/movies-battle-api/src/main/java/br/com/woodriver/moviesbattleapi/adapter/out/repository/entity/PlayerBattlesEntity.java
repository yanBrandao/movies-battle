package br.com.woodriver.moviesbattleapi.adapter.out.repository.entity;

import br.com.woodriver.moviesbattleapi.adapter.out.repository.entity.keys.BattleStatusKey;

import javax.persistence.*;

@Entity
public class PlayerBattlesEntity {
    @EmbeddedId
    BattleStatusKey id;
    String answer;
    @ManyToOne
    @MapsId("battleId")
    @JoinColumn(name = "battle_id")
    BattleEntity battle;

    @ManyToOne
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    PlayerEntity player;
}
