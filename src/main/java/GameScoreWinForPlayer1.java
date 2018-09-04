public class GameScoreWinForPlayer1 implements GameScore {

    @Override
    public String getScoreName() {
        return "Win for player1";
    }

    @Override
    public void pointForPlayer1(Game game) {
        // note - this is already after player1 won earlier, game ended
        game.setScore(GameScores.createGameScoreWinForPlayer1());
    }

    @Override
    public void pointForPlayer2(Game game) {
        // note - this is already after player2 won earlier, game ended
        game.setScore(GameScores.createGameScoreWinForPlayer1());
    }
}
