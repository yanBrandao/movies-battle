package br.com.woodriver.moviesbattleapi.adapter.out.repository;

import br.com.woodriver.moviesbattleapi.adapter.out.repository.jpa.BattleJPARepository;
import br.com.woodriver.moviesbattleapi.adapter.out.repository.mapper.BattleMapper;
import br.com.woodriver.moviesbattleapi.application.domain.Battle;
import br.com.woodriver.moviesbattleapi.application.port.out.BattleRepositoryPort;
import org.springframework.stereotype.Repository;

@Repository
public class BattleRepository implements BattleRepositoryPort {

    BattleJPARepository battleJPARepository;
    public BattleRepository(BattleJPARepository battleJPARepository) {
        this.battleJPARepository = battleJPARepository;
    }
    @Override
    public void save(Battle battle) {
        battleJPARepository.save(BattleMapper.toEntity(battle));
    }
}
