public class GameScoreDeuce implements GameScore {

    @Override
    public String getScoreName() {
        return "Deuce";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.advantagePlayer1());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.advantagePlayer2());
    }
}
