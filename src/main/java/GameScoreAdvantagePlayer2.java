public class GameScoreAdvantagePlayer2 implements GameScore {

    @Override
    public String getScoreName() {
        return "Advantage player2";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreDeuce());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreWinForPlayer2());
    }
}
