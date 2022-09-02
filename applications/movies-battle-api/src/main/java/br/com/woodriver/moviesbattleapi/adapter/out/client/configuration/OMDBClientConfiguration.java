package br.com.woodriver.moviesbattleapi.adapter.out.client.configuration;

import br.com.woodriver.moviesbattleapi.adapter.out.client.properties.OMDBProperties;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.auth.BasicAuthRequestInterceptor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OMDBClientConfiguration {

    private final String apiKey;

    public OMDBClientConfiguration(OMDBProperties properties) {
        apiKey = properties.apiKey;
    }

    @Bean
    RequestInterceptor configure() {
        return new QueryParameterRequestIntercept(apiKey);
    }

    @Getter
    @AllArgsConstructor
    public static class QueryParameterRequestIntercept implements RequestInterceptor {

        String apiKey;

        @Override
        public void apply(RequestTemplate requestTemplate) {
            requestTemplate.query(API_KEY, apiKey);
        }

        private static final String API_KEY = "apikey";
    }
}
