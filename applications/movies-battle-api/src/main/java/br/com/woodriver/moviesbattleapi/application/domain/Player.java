package br.com.woodriver.moviesbattleapi.application.domain;

import br.com.woodriver.moviesbattleapi.application.port.out.PlayerRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    String id;
    String name;
    Battle battleSession;

    public Player(String id) {
        this.id = id;
    }


    public void loadPlayerInformation(PlayerRepositoryPort playerRepository) {
        Player loadPlayer = playerRepository.loadPlayerInformationById(id);

        name = loadPlayer.name;
        battleSession = loadPlayer.battleSession;
    }
}
