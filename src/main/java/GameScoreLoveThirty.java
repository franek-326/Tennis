public class GameScoreLoveThirty implements GameScore {
    @Override
    public String getScoreName() {
        return "Love - Thirty";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreFifteenThirty());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreLoveForty());
    }
}
