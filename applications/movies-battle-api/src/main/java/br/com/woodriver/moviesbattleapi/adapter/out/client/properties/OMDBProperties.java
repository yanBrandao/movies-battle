package br.com.woodriver.moviesbattleapi.adapter.out.client.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;


@ConfigurationProperties(prefix = "omdb")
@ConstructorBinding
@Getter
public class OMDBProperties {
    public String apiKey;

    public OMDBProperties(String apiKey) {
        this.apiKey = apiKey;
    }
}
