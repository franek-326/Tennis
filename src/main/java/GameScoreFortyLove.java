public class GameScoreFortyLove implements GameScore {

    @Override
    public String getScoreName() {
        return "Forty - Love";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreWinForPlayer1());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreFortyFifteen());
    }
}
