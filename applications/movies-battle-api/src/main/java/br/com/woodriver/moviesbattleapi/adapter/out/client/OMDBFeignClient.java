package br.com.woodriver.moviesbattleapi.adapter.out.client;

import br.com.woodriver.moviesbattleapi.adapter.out.client.configuration.OMDBClientConfiguration;
import br.com.woodriver.moviesbattleapi.adapter.out.client.response.OMDBResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        url = "http://www.omdbapi.com/",
        name = "OMDBClient",
        configuration = OMDBClientConfiguration.class
)
public interface OMDBFeignClient {

    @GetMapping
    OMDBResponse findMovieById(@RequestParam(value = "i") String movieId);
}
