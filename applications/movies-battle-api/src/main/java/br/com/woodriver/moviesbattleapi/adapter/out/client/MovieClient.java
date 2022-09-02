package br.com.woodriver.moviesbattleapi.adapter.out.client;

import br.com.woodriver.moviesbattleapi.adapter.out.client.mapper.MovieMapper;
import br.com.woodriver.moviesbattleapi.adapter.out.client.response.OMDBResponse;
import br.com.woodriver.moviesbattleapi.application.domain.Movie;
import br.com.woodriver.moviesbattleapi.application.port.out.MovieClientPort;
import com.github.tomaslanger.chalk.Chalk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MovieClient implements MovieClientPort {

    OMDBFeignClient omdbFeignClient;

    public MovieClient(OMDBFeignClient omdbFeignClient) {
        this.omdbFeignClient = omdbFeignClient;
    }

    @Override
    public Movie findMovieById(String id) {
        logger.debug(String.format("Starting to request movie from OMDB integration with [id=%s]", id));
        OMDBResponse movie = omdbFeignClient.findMovieById(id);

        logger.debug(String.format("Done successfully to get movie [Title=%s]",movie.getTitle()));
        return MovieMapper.toDomain(movie);
    }

    static Logger logger = LoggerFactory.getLogger(MovieClient.class);
}
