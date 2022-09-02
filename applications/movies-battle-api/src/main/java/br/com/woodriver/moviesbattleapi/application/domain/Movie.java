package br.com.woodriver.moviesbattleapi.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    String id;
    String name;
    String bannerURL;
    String year;
    String director;
    BigDecimal rating;

    Movie compareMovie(Movie other) {
        if (this.rating.compareTo(other.rating) >= 0)
            return this;
        else
            return other;
    }
}
