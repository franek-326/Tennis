public class GameScoreThirtyForty implements GameScore {
    @Override
    public String getScoreName() {
        return "Thirty - Forty";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreDeuce());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreWinForPlayer2());
    }
}
