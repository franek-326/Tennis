public class GameScoreFortyFifteen implements GameScore {
    @Override
    public String getScoreName() {
        return "Forty - Fifteen";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreWinForPlayer1());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreFortyThirty());
    }
}
