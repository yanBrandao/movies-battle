package br.com.woodriver.moviesbattleapi.adapter.out.mapper;

import br.com.woodriver.moviesbattleapi.adapter.out.client.response.OMDBResponse;
import br.com.woodriver.moviesbattleapi.adapter.out.repository.entity.MovieEntity;
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

    public static Movie toDomain(MovieEntity entity) {
        return new Movie(
                entity.getId(),
                entity.getName(),
                entity.getBannerURL(),
                entity.getYear(),
                entity.getDirector(),
                entity.getRating()
        );
    }

    public static MovieEntity toEntity(Movie movie) {
        return new MovieEntity(
                movie.getId(),
                movie.getName(),
                movie.getBannerURL(),
                movie.getYear(),
                movie.getDirector(),
                movie.getRating()
        );
    }
}
