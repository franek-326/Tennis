public class GameScoreThirtyFifteen implements GameScore {
    @Override
    public String getScoreName() {
        return "Thirty - Fifteen";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreFortyFifteen());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreThirtyThirty());
    }
}
