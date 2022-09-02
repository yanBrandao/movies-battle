package br.com.woodriver.moviesbattleapi.adapter.out.repository;

import br.com.woodriver.moviesbattleapi.application.domain.Battle;
import br.com.woodriver.moviesbattleapi.application.port.out.BattleRepositoryPort;
import org.springframework.stereotype.Repository;

@Repository
public class BattleFakeRepository implements BattleRepositoryPort {
    @Override
    public void save(Battle battle) {

    }
}
