public class GameScoreThirtyLove implements GameScore {
    @Override
    public String getScoreName() {
        return "Thirty - Love";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreFortyLove());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreThirtyFifteen());
    }
}
