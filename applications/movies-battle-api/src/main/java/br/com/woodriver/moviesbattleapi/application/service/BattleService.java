package br.com.woodriver.moviesbattleapi.application.service;

import br.com.woodriver.moviesbattleapi.application.domain.Battle;
import br.com.woodriver.moviesbattleapi.application.domain.Player;
import br.com.woodriver.moviesbattleapi.application.exception.BattleAlreadyStartedException;
import br.com.woodriver.moviesbattleapi.application.exception.PlayerWithoutBattleActiveException;
import br.com.woodriver.moviesbattleapi.application.port.in.CurrentBattleUseCase;
import br.com.woodriver.moviesbattleapi.application.port.in.StartBattleUseCase;
import br.com.woodriver.moviesbattleapi.application.port.out.BattleRepositoryPort;
import br.com.woodriver.moviesbattleapi.application.port.out.FileManagerPort;
import br.com.woodriver.moviesbattleapi.application.port.out.MovieClientPort;
import br.com.woodriver.moviesbattleapi.application.port.out.PlayerRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class BattleService implements StartBattleUseCase, CurrentBattleUseCase {

    private BattleRepositoryPort battleRepositoryPort;
    private PlayerRepositoryPort playerRepositoryPort;
    private FileManagerPort fileManagerPort;

    private MovieClientPort movieClientPort;

    public BattleService(BattleRepositoryPort battleRepositoryPort,
                         PlayerRepositoryPort playerRepositoryPort,
                         MovieClientPort movieClientPort,
                         FileManagerPort fileManagerPort) {
        this.battleRepositoryPort = battleRepositoryPort;
        this.playerRepositoryPort = playerRepositoryPort;
        this.movieClientPort = movieClientPort;
        this.fileManagerPort = fileManagerPort;
    }

    @Override
    public void executePost(Player player) {
        player.loadPlayerInformation(playerRepositoryPort);

        if (player.getBattleSession() == null) {

            Battle battle = new Battle();

            battle.startBattle(battleRepositoryPort, movieClientPort, fileManagerPort, player);
        } else {
            throw new BattleAlreadyStartedException("Could not start battle because this player is already in battle.");
        }
    }

    @Override
    public Battle executeGet(Player player) {
        player.loadPlayerInformation(playerRepositoryPort);

        if (player.getActiveBattleSession() != null) {
            return player.getActiveBattleSession();
        } else {
            throw new PlayerWithoutBattleActiveException(String.format("This [player=%s] doesn't have battle active", player.getId()));
        }
    }
}
