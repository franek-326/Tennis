public class GameScoreDeuce implements GameScore {
    @Override
    public String getScoreName() {
        return "Deuce";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreAdvantagePlayer1());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreAdvantagePlayer2());
    }
}
