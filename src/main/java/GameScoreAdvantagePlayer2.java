public class GameScoreAdvantagePlayer2 implements GameScore {
    @Override
    public String getScoreName() {
        return "Advantage player2";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreDeuce());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreWinForPlayer2());
    }
}
