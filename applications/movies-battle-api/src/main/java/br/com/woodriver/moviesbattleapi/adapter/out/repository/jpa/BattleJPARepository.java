package br.com.woodriver.moviesbattleapi.adapter.out.repository.jpa;

import br.com.woodriver.moviesbattleapi.adapter.out.repository.entity.BattleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BattleJPARepository extends JpaRepository<BattleEntity, Integer> {
}
