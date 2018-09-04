public class GameScoreLoveThirty implements GameScore {

    @Override
    public String getScoreName() {
        return "Love - Thirty";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreFifteenThirty());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreLoveForty());
    }
}
