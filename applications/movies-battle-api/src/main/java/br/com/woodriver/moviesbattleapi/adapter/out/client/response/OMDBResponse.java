package br.com.woodriver.moviesbattleapi.adapter.out.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OMDBResponse {
    String imdbID;
    @JsonProperty(value = "Poster")
    String poster;
    @JsonProperty(value = "Title")
    String title;
    String imdbRating;
    @JsonProperty(value = "Year")
    String year;
    @JsonProperty(value = "Director")
    String director;
}
