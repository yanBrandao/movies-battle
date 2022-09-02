package br.com.woodriver.moviesbattleapi.adapter.out.repository.entity;

import br.com.woodriver.moviesbattleapi.application.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.util.Pair;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
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
//    Pair<Movie, Movie> currentQuestion;
//    HashMap<Pair<Movie, Movie>, String> historyAnswer = new HashMap<>();
}
