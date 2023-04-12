package com.erikk.yolo.service;

import com.erikk.yolo.object.GameResponse;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class GameService {

    public GameResponse playGame(double betAmount, double playerNumber) {
        double randomNumber = ThreadLocalRandom.current().nextInt(1,101);
        double winAmount = betAmount * (99.0 / (100 - playerNumber));
        boolean isWin = playerNumber > randomNumber;
        GameResponse gameResponse = new GameResponse(isWin, randomNumber, winAmount);
        return gameResponse;
    }
}
