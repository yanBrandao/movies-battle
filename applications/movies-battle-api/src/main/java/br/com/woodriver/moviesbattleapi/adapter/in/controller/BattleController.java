package br.com.woodriver.moviesbattleapi.adapter.in.controller;

import br.com.woodriver.moviesbattleapi.adapter.in.api.BattleAPI;
import br.com.woodriver.moviesbattleapi.application.domain.Player;
import br.com.woodriver.moviesbattleapi.application.port.in.StartBattleUseCase;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BattleController implements BattleAPI {

    private StartBattleUseCase startBattleUseCase;

    public BattleController(StartBattleUseCase startBattleUseCase) {
        this.startBattleUseCase = startBattleUseCase;
    }

    @Override
    public void startBattle(String authorization) {
        String playerId = (String) getAllClaimsFromToken(authorization).get("user_id");
        startBattleUseCase.execute(new Player(playerId));
    }

    @Override
    public void getCurrentPlayerBattle(String authorization) {

    }

    @Override
    public void finishBattle(String authorization) {

    }

    private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            logger.error("Could not get all claims Token from passed token");
            claims = null;
        }
        return claims;
    }

    private static final String SECRET = "some_secret";
    static Logger logger = LoggerFactory.getLogger(BattleController.class);
}
