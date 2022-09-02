package br.com.woodriver.moviesbattleapi.adapter.in.api;

import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/battles")
public interface BattleAPI {

    @PostMapping
    void startBattle(@RequestHeader("Authorization") String authorization);

    @GetMapping
    void getCurrentPlayerBattle(@RequestHeader("Authorization") String authorization);

    @DeleteMapping
    void finishBattle(@RequestHeader("Authorization") String authorization);
}
