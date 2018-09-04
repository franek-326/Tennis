public class GameScoreThirtyThirty implements GameScore {

    @Override
    public String getScoreName() {
        return "Thirty - Thirty";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreFortyThirty());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreThirtyForty());
    }
}
