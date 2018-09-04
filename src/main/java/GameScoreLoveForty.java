
public class GameScoreLoveForty implements GameScore {

    @Override
    public String getScoreName() {
        return "Love - Forty";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreFifteenForty());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreWinForPlayer2());
    }
}
