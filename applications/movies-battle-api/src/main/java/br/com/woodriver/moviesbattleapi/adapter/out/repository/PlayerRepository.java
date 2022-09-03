package br.com.woodriver.moviesbattleapi.adapter.out.repository;

import br.com.woodriver.moviesbattleapi.adapter.out.repository.entity.PlayerEntity;
import br.com.woodriver.moviesbattleapi.adapter.out.repository.jpa.PlayerJPARepository;
import br.com.woodriver.moviesbattleapi.adapter.out.mapper.PlayerMapper;
import br.com.woodriver.moviesbattleapi.application.domain.Player;
import br.com.woodriver.moviesbattleapi.application.exception.PlayerNotFoundException;
import br.com.woodriver.moviesbattleapi.application.port.out.PlayerRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PlayerRepository implements PlayerRepositoryPort {
    private final PlayerJPARepository playerJPARepository;

    public PlayerRepository(PlayerJPARepository playerJPARepository) {
        this.playerJPARepository = playerJPARepository;
    }
    @Override
    public Player loadPlayerInformationById(String id) {
        Optional<PlayerEntity> entity = playerJPARepository.findById(id);
        if (entity.isPresent()) {
            return PlayerMapper.toDomain(entity.get());
        } else {
            throw new PlayerNotFoundException("Could not found player in database");
        }

    }
}
