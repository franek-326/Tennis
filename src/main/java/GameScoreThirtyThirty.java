public class GameScoreThirtyThirty implements GameScore {
    @Override
    public String getScoreName() {
        return "Thirty - Thirty";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreFortyThirty());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreThirtyForty());
    }
}
