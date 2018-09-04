public class GameScoreFortyThirty implements GameScore {

    @Override
    public String getScoreName() {
        return "Forty - Thirty";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreWinForPlayer1());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreDeuce());
    }
}
