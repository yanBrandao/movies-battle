package br.com.woodriver.moviesbattleapi.adapter.out.file;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    FileManager fileManager = new FileManager();

    @Test
    void shouldReadFileSuccessfully() {
        LinkedHashMap map = null;
        try {
            map = fileManager.loadMovies();
        } catch (Exception ex) {
            System.out.println("Failed to read movies from file");
        }

        assertNotNull(map);
        assertEquals(6, map.size());
    }
}