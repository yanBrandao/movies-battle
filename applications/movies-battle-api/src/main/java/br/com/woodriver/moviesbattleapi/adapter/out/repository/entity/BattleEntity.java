package br.com.woodriver.moviesbattleapi.adapter.out.repository.entity;

import br.com.woodriver.moviesbattleapi.application.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.util.Pair;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashMap;

@Entity(name = "Battles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BattleEntity {

    @Id
    Integer id;
    int score = 0;
    int failures = 0;
    boolean isActive;
    @ManyToOne
    MovieEntity firstOption;
    @ManyToOne
    MovieEntity secondOption;
    @ManyToOne
    PlayerEntity player;
}
