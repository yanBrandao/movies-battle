package br.com.woodriver.moviesbattleapi.application.port.in;

import br.com.woodriver.moviesbattleapi.application.domain.Player;

public interface StartBattleUseCase {
    void executePost(Player player);
}
