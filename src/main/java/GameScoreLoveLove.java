public class GameScoreLoveLove implements GameScore {

    @Override
    public String getScoreName() {
        return "Love - Love";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreFifteenLove());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreLoveFifteen());
    }
}
