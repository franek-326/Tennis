public class GameScoreFifteenLove implements GameScore {

    @Override
    public String getScoreName() {
        return "Fifteen - Love";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreThirtyLove());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreFifteenFifteen());
    }
}
