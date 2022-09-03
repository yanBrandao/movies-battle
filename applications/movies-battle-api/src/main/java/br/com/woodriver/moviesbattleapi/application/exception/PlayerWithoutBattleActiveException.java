package br.com.woodriver.moviesbattleapi.application.exception;

public class PlayerWithoutBattleActiveException extends RuntimeException{
    public PlayerWithoutBattleActiveException(String message) {
        super(message);
    }

}
