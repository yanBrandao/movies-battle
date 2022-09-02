package br.com.woodriver.moviesbattleapi.application.port.out;

import java.net.URISyntaxException;
import java.util.LinkedHashMap;

public interface FileManagerPort {

    LinkedHashMap<String, String> loadMovies();
}
