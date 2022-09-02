package br.com.woodriver.moviesbattleapi.application.domain;

import br.com.woodriver.moviesbattleapi.application.port.out.BattleRepositoryPort;
import br.com.woodriver.moviesbattleapi.application.port.out.FileManagerPort;
import br.com.woodriver.moviesbattleapi.application.port.out.MovieClientPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.util.Pair;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Battle {
    int score = 0;
    int failures = 0;
    Pair<Movie, Movie> currentQuestion;
    HashMap<Pair<Movie, Movie>, String> historyAnswer = new HashMap<>();


    public void startBattle(BattleRepositoryPort battleRepositoryPort,
                            MovieClientPort movieClientPort,
                            FileManagerPort fileManagerPort) {
        currentQuestion = generateNewMoviesPair(movieClientPort, fileManagerPort);

        battleRepositoryPort.save(this);
    }

    void answerQuestion(Movie option, MovieClientPort movieClientPort, FileManagerPort fileManagerPort) {
        if (Objects.equals(option.id, currentQuestion.getFirst().compareMovie(currentQuestion.getSecond()).id)){
            score++;
            historyAnswer.put(currentQuestion, CORRECT);
        } else {
            failures++;
            historyAnswer.put(currentQuestion, INCORRECT);
        }

        currentQuestion = generateNewMoviesPair(movieClientPort, fileManagerPort);
    }

    private Pair<Movie, Movie> generateNewMoviesPair(MovieClientPort movieClientPort, FileManagerPort fileManagerPort) {
        LinkedHashMap<String, String> movies = fileManagerPort.loadMovies();
        Movie movieOne = movieClientPort.findMovieById(getRandomMovie(movies));
        Movie movieTwo = movieClientPort.findMovieById("B");

       return Pair.of(movieOne, movieTwo);
    }

    private Pair<String, String> getRandomMovie(LinkedHashMap<String, String> movies) {
        Random random = new Random();
        int position = random.nextInt(movies.size());
        List<String> moviesAsList = new ArrayList<>(movies.keySet());

        return Pair.of(moviesAsList.get(position), moviesAsList.get(position));
    }

    private static final String CORRECT = "Correct Answer";
    private static final String INCORRECT = "Incorrect Answer";
}
