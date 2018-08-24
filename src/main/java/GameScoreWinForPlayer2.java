public class GameScoreWinForPlayer2 implements GameScore {
    @Override
    public String getScoreName() {
        return "Win for player2";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreWinForPlayer2());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreWinForPlayer2());
    }
}
