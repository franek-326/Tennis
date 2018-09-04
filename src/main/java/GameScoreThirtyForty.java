public class GameScoreThirtyForty implements GameScore {

    @Override
    public String getScoreName() {
        return "Thirty - Forty";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreDeuce());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreWinForPlayer2());
    }
}
