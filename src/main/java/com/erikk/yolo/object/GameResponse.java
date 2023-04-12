package com.erikk.yolo.object;

public class GameResponse {
    private boolean win;
    private double randomNumber;
    private double winningAmount;

    public GameResponse(boolean win, double randomNumber, double winningAmount) {
        this.win = win;
        this.randomNumber = randomNumber;
        this.winningAmount = winningAmount;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public double getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(double randomNumber) {
        this.randomNumber = randomNumber;
    }

    public double getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(double winningAmount) {
        this.winningAmount = winningAmount;
    }
}
