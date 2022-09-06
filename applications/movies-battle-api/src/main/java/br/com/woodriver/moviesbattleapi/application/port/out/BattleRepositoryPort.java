package br.com.woodriver.moviesbattleapi.application.port.out;

import br.com.woodriver.moviesbattleapi.application.domain.Battle;
import br.com.woodriver.moviesbattleapi.application.domain.Player;

public interface BattleRepositoryPort {

    void save(Battle battle, Player player);
}
