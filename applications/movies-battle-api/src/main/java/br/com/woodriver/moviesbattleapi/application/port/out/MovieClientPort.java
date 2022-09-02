package br.com.woodriver.moviesbattleapi.application.port.out;

import br.com.woodriver.moviesbattleapi.application.domain.Movie;

public interface MovieClientPort {

    Movie findMovieById(String id);
}
