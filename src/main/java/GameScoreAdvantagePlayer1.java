public class GameScoreAdvantagePlayer1 implements GameScore {
    @Override
    public String getScoreName() {
        return "Advantage player1";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreWinForPlayer1());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreDeuce());
    }
}
