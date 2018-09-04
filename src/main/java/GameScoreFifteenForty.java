public class GameScoreFifteenForty implements GameScore {

    @Override
    public String getScoreName() {
        return "Fifteen - Forty";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreThirtyForty());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreWinForPlayer2());
    }
}
