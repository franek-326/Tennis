public class GameScoreLoveFifteen implements GameScore {

    @Override
    public String getScoreName() {
        return "Love - Fifteen";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreFifteenFifteen());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreLoveThirty());
    }
}
