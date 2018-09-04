public class GameScoreFifteenLove implements GameScore {

    @Override
    public String getScoreName() {
        return "Fifteen - Love";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreThirtyLove());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreFifteenFifteen());
    }
}
