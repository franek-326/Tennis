public class GameScoreLoveLove implements GameScore {

    @Override
    public String getScoreName() {
        return "Love - Love";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreFifteenLove());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreLoveFifteen());
    }
}
