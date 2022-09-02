package br.com.woodriver.moviesbattleapi.application.port.in;

import br.com.woodriver.moviesbattleapi.application.domain.Battle;
import br.com.woodriver.moviesbattleapi.application.domain.Player;

public interface CurrentBattleUseCase {
    Battle executeGet(Player player);
}
