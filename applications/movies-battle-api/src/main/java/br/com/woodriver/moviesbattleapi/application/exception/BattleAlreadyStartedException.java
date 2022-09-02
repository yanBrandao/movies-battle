package br.com.woodriver.moviesbattleapi.application.exception;

public class BattleAlreadyStartedException extends RuntimeException{

    public BattleAlreadyStartedException(String message) {
        super(message);
    }
}
