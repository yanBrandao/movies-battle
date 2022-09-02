package br.com.woodriver.moviesbattleapi;

import br.com.woodriver.moviesbattleapi.adapter.out.client.properties.OMDBProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(OMDBProperties.class)
public class MoviesBattleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesBattleApiApplication.class, args);
	}

}
