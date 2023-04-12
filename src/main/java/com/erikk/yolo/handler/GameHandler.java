package com.erikk.yolo.handler;

import com.erikk.yolo.object.GameRequest;
import com.erikk.yolo.object.GameResponse;
import com.erikk.yolo.service.GameService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class GameHandler extends TextWebSocketHandler {
    @Autowired
    GameService gameService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            GameRequest gameRequest = objectMapper.readValue(message.getPayload(), GameRequest.class);
            if (gameRequest.getBetAmount() <= 0 || gameRequest.getPlayerNumber() < 1 || gameRequest.getPlayerNumber() > 100) {
                session.sendMessage(new TextMessage("Invalid bet amount/player number!"));
            } else {
                GameResponse gameResponse = gameService.playGame(gameRequest.getBetAmount(), gameRequest.getPlayerNumber());
                if (gameResponse.isWin()) {
                    session.sendMessage(new TextMessage("You won! Your winnings are " + gameResponse.getWinningAmount() + " $"));

                } else {
                    session.sendMessage(new TextMessage("You lost!"));
                }
            }
        } catch (JsonParseException e) {
            session.sendMessage(new TextMessage("Invalid format"));
        } catch (NumberFormatException e) {
            session.sendMessage(new TextMessage("Invalid number"));
        }
    }
}
