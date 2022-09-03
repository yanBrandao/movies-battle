package br.com.woodriver.moviesbattleapi.adapter.out.repository.jpa;

import br.com.woodriver.moviesbattleapi.adapter.out.repository.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerJPARepository extends JpaRepository<PlayerEntity, String> {
}
