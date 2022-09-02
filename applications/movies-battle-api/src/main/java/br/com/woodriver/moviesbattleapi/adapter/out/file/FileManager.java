package br.com.woodriver.moviesbattleapi.adapter.out.file;

import br.com.woodriver.moviesbattleapi.application.port.out.FileManagerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedHashMap;

@Configuration
public class FileManager implements FileManagerPort {

    @Bean
    public LinkedHashMap<String, String> loadMovies() {
        String fileName = "movie-list.txt";
        URL resource  = getClass().getClassLoader().getResource(fileName);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        String line;

        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            try {
                File file = new File(resource.toURI());

                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while ((line = reader.readLine()) != null) {
                        String[] keyValuePair = line.split(",", 2);
                        if (keyValuePair.length > 1) {
                            String key = keyValuePair[0];
                            String value = keyValuePair[1];
                            map.putIfAbsent(key, value);
                        } else {
                            System.out.println("No Key:Value found in line, ignoring: " + line);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception ex) {
                System.out.println("Could not load file");
            }
        }
        return map;
    }
}
