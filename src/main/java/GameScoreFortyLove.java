public class GameScoreFortyLove implements GameScore {
    @Override
    public String getScoreName() {
        return "Forty - Love";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreWinForPlayer1());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreFortyFifteen());
    }
}
