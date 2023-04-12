package com.erikk.yolo.object;

public class GameRequest {
    private double betAmount;
    private double playerNumber;

    public GameRequest(double betAmount, double playerNumber) {
        this.betAmount = betAmount;
        this.playerNumber = playerNumber;
    }
    public GameRequest(){

    }
    public double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }

    public double getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(double playerNumber) {
        this.playerNumber = playerNumber;
    }
}
