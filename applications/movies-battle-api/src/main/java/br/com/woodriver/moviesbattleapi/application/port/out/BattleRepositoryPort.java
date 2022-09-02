package br.com.woodriver.moviesbattleapi.application.port.out;

import br.com.woodriver.moviesbattleapi.application.domain.Battle;

public interface BattleRepositoryPort {

    void save(Battle battle);
}
