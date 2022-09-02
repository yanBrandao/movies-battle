package br.com.woodriver.moviesbattleapi.application.port.out;

import br.com.woodriver.moviesbattleapi.application.domain.Player;

public interface PlayerRepositoryPort {

    Player loadPlayerInformationById(String id);
}
