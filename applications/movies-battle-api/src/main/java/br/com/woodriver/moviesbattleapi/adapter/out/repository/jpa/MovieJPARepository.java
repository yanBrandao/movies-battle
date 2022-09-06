package br.com.woodriver.moviesbattleapi.adapter.out.repository.jpa;

import br.com.woodriver.moviesbattleapi.adapter.out.repository.entity.BattleEntity;
import br.com.woodriver.moviesbattleapi.adapter.out.repository.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieJPARepository extends JpaRepository<MovieEntity, String> {
}
