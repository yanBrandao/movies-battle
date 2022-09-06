package br.com.woodriver.moviesbattleapi.adapter.out.repository;

import br.com.woodriver.moviesbattleapi.adapter.out.mapper.MovieMapper;
import br.com.woodriver.moviesbattleapi.adapter.out.repository.jpa.BattleJPARepository;
import br.com.woodriver.moviesbattleapi.adapter.out.mapper.BattleMapper;
import br.com.woodriver.moviesbattleapi.adapter.out.repository.jpa.MovieJPARepository;
import br.com.woodriver.moviesbattleapi.application.domain.Battle;
import br.com.woodriver.moviesbattleapi.application.domain.Player;
import br.com.woodriver.moviesbattleapi.application.port.out.BattleRepositoryPort;
import org.springframework.stereotype.Repository;

@Repository
public class BattleRepository implements BattleRepositoryPort {

    BattleJPARepository battleJPARepository;
    MovieJPARepository movieJPARepository;
    public BattleRepository(BattleJPARepository battleJPARepository, MovieJPARepository movieJPARepository) {
        this.battleJPARepository = battleJPARepository;
        this.movieJPARepository = movieJPARepository;
    }
    @Override
    public void save(Battle battle, Player player) {
        if (movieJPARepository.findById(battle.getCurrentQuestion().getFirst().getId()).isEmpty()) {
            movieJPARepository.save(MovieMapper.toEntity(battle.getCurrentQuestion().getFirst()));
        }
        if (movieJPARepository.findById(battle.getCurrentQuestion().getSecond().getId()).isEmpty()) {
            movieJPARepository.save(MovieMapper.toEntity(battle.getCurrentQuestion().getSecond()));
        }
        battleJPARepository.save(BattleMapper.toEntity(battle, player));
    }
}
