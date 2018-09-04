public class GameScoreWinForPlayer2 implements GameScore {

    @Override
    public String getScoreName() {
        return "Win for player2";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreWinForPlayer2());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreWinForPlayer2());
    }
}
