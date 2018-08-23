import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TennisGameTests {

    @Test
    // 0 - 0 Love - Love
    public void shouldDisplayLoveLoveOnTheGameStart() {
        // GIVEN
        TennisGame tg = new TennisGame();
        String score = tg.getScore();

        // WHEN THEN
        assertThat(score).isEqualTo("Love - Love");
    }

    @Test
    // 0-0 -> 1-0 Fifteen - Love
    public void shouldDisplayFifteenLoveAfterPlayerOneScoresAtLoveLove() {
        //GIVEN
        TennisGame tg = new TennisGame();

        //WHEN
        tg.wonPoint("player1");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Fifteen - Love");
    }

    @Test
    // 0-0 -> 0-1 Love - Fifteen
    public void shouldDisplayLoveFifteenAfterPlayerOneScoresAtLoveLove() {
        //GIVEN
        TennisGame tg = new TennisGame();

        //WHEN
        tg.wonPoint("player2");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Love - Fifteen");
    }

    @Test
    @Parameters({"player1", "player2"})
    // 1-0 & 0-1 -> 1-1 Fifteen - Fifteen
    public void shouldDisplayFifteenFifteenAfterCorrectPlayerScoresAtLoveFifteenOrFifteenLove(String scoringPlayer) {
        //GIVEN
        TennisGame tg = new TennisGame();
        if (scoringPlayer.equals("player1"))
            tg.setScore(new GameScoreLoveFifteen());
        else
            tg.setScore(new GameScoreFifteenLove());

        //WHEN
        tg.wonPoint(scoringPlayer);

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Fifteen - Fifteen");

    }


    @Test
    // 1-1 -> 2-1 Thirty - Fifteen
    public void shouldDisplayThirtyFifteenAfterPlayer1ScoresAtFifteenFifteen() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreFifteenFifteen());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Thirty - Fifteen");

    }

    @Test
    // 1-1 -> 1-2 Thirty - Fifteen
    public void shouldDisplayFifteenThirtyAfterPlayer2ScoresAtFifteenFifteen() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreFifteenFifteen());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Fifteen - Thirty");

    }

    @Test
    // 0-1 -> 0-2 Love - Thirty
    public void shouldDisplayLoveThirtyAfterPlayer2ScoresAtLoveFifteen() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreLoveFifteen());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Love - Thirty");

    }

    @Test
    // 1-0 -> 2-0 Thirty - Love
    public void shouldDisplayThirtyLoveAfterPlayer1ScoresAtFifteenLove() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreFifteenLove());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Thirty - Love");

    }

    @Test
    // 3-1 - Forty - Fifteen
    public void shouldDisplayFortyFifteenWhenTheScoreIs31() {
        //GIVEN
        TennisGame tg = new TennisGame();

        //WHEN
        tg.wonPoint("player1");
        tg.wonPoint("player2");
        tg.wonPoint("player1");
        tg.wonPoint("player1");

        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Forty - Fifteen");

    }

    @Test
    // 4-1 - Win for player1
    public void shouldDisplayWinForPlayer1WhenTheScoreIs41() {
        //GIVEN
        TennisGame tg = new TennisGame();

        //WHEN
        tg.wonPoint("player1");
        tg.wonPoint("player2");
        tg.wonPoint("player1");
        tg.wonPoint("player1");
        tg.wonPoint("player1");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Win for player1");

    }

    @Test
    // 1-4 - Win for player2
    public void shouldDisplayWinForPlayer2WhenTheScoreIs14() {
        //GIVEN
        TennisGame tg = new TennisGame();

        //WHEN
        tg.wonPoint("player2");
        tg.wonPoint("player1");
        tg.wonPoint("player2");
        tg.wonPoint("player2");
        tg.wonPoint("player2");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Win for player2");

    }

    @Test
    // 4-3 - Advantage player1
    public void shouldDisplayAdvantagePlayer1WhenTheScoreIs43() {
        //GIVEN
        TennisGame tg = new TennisGame();

        //WHEN
        tg.wonPoint("player1");
        tg.wonPoint("player2");
        tg.wonPoint("player2");
        tg.wonPoint("player2");
        tg.wonPoint("player1");
        tg.wonPoint("player1");
        tg.wonPoint("player1");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Advantage player1");

    }

    @Test
    // 3-4 - Advantage player2
    public void shouldDisplayAdvantagePlayer2WhenTheScoreIs34() {
        //GIVEN
        TennisGame tg = new TennisGame();

        //WHEN
        tg.wonPoint("player2");
        tg.wonPoint("player1");
        tg.wonPoint("player1");
        tg.wonPoint("player1");
        tg.wonPoint("player2");
        tg.wonPoint("player2");
        tg.wonPoint("player2");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Advantage player2");

    }

    @Test
    // 3-3 - Deuce
    public void shouldDisplayDeuceWhenTheScoreIs33() {
        //GIVEN
        TennisGame tg = new TennisGame();

        //WHEN
        tg.wonPoint("player1");
        tg.wonPoint("player1");
        tg.wonPoint("player1");
        tg.wonPoint("player2");
        tg.wonPoint("player2");
        tg.wonPoint("player2");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Deuce");

    }

}