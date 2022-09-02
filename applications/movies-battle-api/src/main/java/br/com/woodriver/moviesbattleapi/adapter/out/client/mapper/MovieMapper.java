package br.com.woodriver.moviesbattleapi.adapter.out.client.mapper;

import br.com.woodriver.moviesbattleapi.adapter.out.client.response.OMDBResponse;
import br.com.woodriver.moviesbattleapi.application.domain.Movie;

import java.math.BigDecimal;

public class MovieMapper {

    public static Movie toDomain(OMDBResponse response) {
        return new Movie(
                response.getImdbID(),
                response.getTitle(),
                response.getPoster(),
                response.getYear(),
                response.getDirector(),
                new BigDecimal(response.getImdbRating())
        );
    }
}
