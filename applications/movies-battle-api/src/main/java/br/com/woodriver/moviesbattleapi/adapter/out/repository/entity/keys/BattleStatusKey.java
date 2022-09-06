package br.com.woodriver.moviesbattleapi.adapter.out.repository.entity.keys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BattleStatusKey implements Serializable {

    @Column(name = "player_id")
    String playerId;
    @Column(name = "battle_id")
    Integer battleId;
}
