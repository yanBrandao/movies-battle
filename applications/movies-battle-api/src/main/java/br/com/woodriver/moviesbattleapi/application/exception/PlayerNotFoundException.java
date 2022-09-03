package br.com.woodriver.moviesbattleapi.application.exception;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(String message) {
        super(message);
    }

}
