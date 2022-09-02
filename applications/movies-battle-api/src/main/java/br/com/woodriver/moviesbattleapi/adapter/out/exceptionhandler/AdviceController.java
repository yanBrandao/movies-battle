package br.com.woodriver.moviesbattleapi.adapter.out.exceptionhandler;

import br.com.woodriver.moviesbattleapi.application.exception.BattleAlreadyStartedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class AdviceController {

    private static final String BATTLE_ALREADY_STARTED_ERROR_CODE = "BAT001";

    @ExceptionHandler(BattleAlreadyStartedException.class)
    @ResponseStatus(value = BAD_REQUEST)
    public ErrorMessageResponse resourceNotFoundException(BattleAlreadyStartedException ex, WebRequest request) {
        return new ErrorMessageResponse(
                BATTLE_ALREADY_STARTED_ERROR_CODE,
                LocalDateTime.now().toString(),
                ex.getMessage()
        );
    }
}
