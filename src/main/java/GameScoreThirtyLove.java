public class GameScoreThirtyLove implements GameScore {

    @Override
    public String getScoreName() {
        return "Thirty - Love";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreFortyLove());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreThirtyFifteen());
    }
}
