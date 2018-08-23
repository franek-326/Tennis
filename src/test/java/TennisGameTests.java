import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    // 1 - 0 Fifteen - Love
    public void shouldDisplayFifteenLoveWhenWonPointForPlayerOneIsCalledAfterGameStarts() {
        //GIVEN
        TennisGame tg = new TennisGame();

        //WHEN
        tg.wonPoint("player1");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Fifteen - Love");


    }

    @Test
    // 0 - 1 Love - Fifteen
    public void shouldDisplayLoveFifteenWhenWonPointForPlayerOneIsCalledAfterGameStarts() {
        //GIVEN
        TennisGame tg = new TennisGame();

        //WHEN
        tg.wonPoint("player2");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Love - Fifteen");


    }

    @Test
    // 1-1 Fifteen - Fifteen
    public void shouldDisplayFifteenFifteenWhenWonPointForPlayerOneAndTwoAreCalledAfterGameStarts() {
        //GIVEN
        TennisGame tg = new TennisGame();

        //WHEN
        tg.wonPoint("player1");
        tg.wonPoint("player2");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Fifteen - Fifteen");


    }

    @Test
    // 2-1 Thirty - Fifteen
    public void shouldDisplayThirtyFifteenWhenTheScoreIs21() {
        //GIVEN
        TennisGame tg = new TennisGame();

        //WHEN
        tg.wonPoint("player1");
        tg.wonPoint("player2");
        tg.wonPoint("player1");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Thirty - Fifteen");

    }


    @Test
    // 3-1 - Forty - Fifteen
    public void shouldDisplayFortyFifteenWhenTheScoreIs41() {
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