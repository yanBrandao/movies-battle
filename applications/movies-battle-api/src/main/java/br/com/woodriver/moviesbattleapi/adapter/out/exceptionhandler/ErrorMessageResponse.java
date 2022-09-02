package br.com.woodriver.moviesbattleapi.adapter.out.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorMessageResponse {
    String errorCode;
    String date;
    String exceptionMessage;
}
