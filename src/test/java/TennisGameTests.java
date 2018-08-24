import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/*
Transformations tested (all):
00
00-01
00-10
01-02
01-11
10-11
10-20
02-03
03-13
12-13
12-22
11-21
11-12
13-23
20-30
20-21
21-22
21-31
22-23
22-32
30-31
31 - 32
30 - WinPlayer1
23 - Deuce
23 - WinPlayer2
32 - Deuce
03 - WinPlayer2
31 - WinPlayer1
13 - WinPlayer2
33 - AdvPlayer1
33 - AdvPlayer2
32 - WinPlayer1
Deuce - AdvPlayer1
Deuce - AdvPlayer2
AdvPlayer1 - Deuce
AdvPlayer2 - Deuce
AdvPlayer1 - WinPlayer1
AdvPlayer2 - WinPlayer2
additionally (not specified in the rules):
WinPlayer1 - WinPlayer1
WinPlayer2 - WinPlayer2
 */
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
    public void shouldDisplayFifteenFifteenAfterLoosingPlayerScoresAtLoveFifteenOrFifteenLove(String scoringPlayer) {
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
    @Parameters({"player1", "player2"})
    // 2-1 & 1-2 -> 2-2 Thirty - Thirty
    public void shouldDisplayThirtyThirtyAfterLoosingPlayerScoresAtThirtyFifteenOrFifteenThirty(String scoringPlayer) {
        //GIVEN
        TennisGame tg = new TennisGame();
        if (scoringPlayer.equals("player1"))
            tg.setScore(new GameScoreFifteenThirty());
        else
            tg.setScore(new GameScoreThirtyFifteen());

        //WHEN
        tg.wonPoint(scoringPlayer);

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Thirty - Thirty");
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
    // 1-1 -> 1-2 Fifteen - Thirty
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
    // 2-0 -> 3-0 Forty - Love
    public void shouldDisplayFortyLoveAfterPlayer1ScoresAtThirtyLove() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreThirtyLove());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Forty - Love");
    }

    @Test
    // 2-0 -> 2-1 Thirty - Fifteen
    public void shouldDisplayThirtyFifteenAfterPlayer2ScoresAtThirtyLove() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreThirtyLove());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Thirty - Fifteen");
    }

    @Test
    // 0-2 -> 0-3 Love - Forty
    public void shouldDisplayLoveFortyAfterPlayer2ScoresAtLoveThirty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreLoveThirty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Love - Forty");
    }

    @Test
    // 0-3 -> WinPlayer2
    public void shouldDisplayWinForPlayer2AfterPlayer2ScoresAtLoveForty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreLoveForty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Win for player2");
    }

    @Test
    // 0-3 -> WinPlayer2
    public void shouldDisplayFifteenFortyAfterPlayer1ScoresAtLoveForty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreLoveForty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Fifteen - Forty");
    }

    @Test
    // 0-2 -> 1-2 Fifteen - Thirty
    public void shouldDisplayFifteenThirtyAfterPlayer1ScoresAtLoveThirty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreLoveThirty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Fifteen - Thirty");
    }

    @Test
    // 2-1 -> 3-1 Forty - Fifteen
    public void shouldDisplayFortyFifteenAfterPlayer1ScoresAtThirtyFifteen() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreThirtyFifteen());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Forty - Fifteen");
    }


    @Test
    // 2-1 -> 2-2 Thirty - Thirty
    public void shouldDisplayThirtyThirtyAfterPlayer2ScoresAtThirtyFifteen() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreThirtyFifteen());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Thirty - Thirty");
    }

    @Test
    // 2-2 -> 2-3 Thirty - Forty
    public void shouldDisplayThirtyFortyAfterPlayer2ScoresAtThirtyThirty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreThirtyThirty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Thirty - Forty");
    }

    @Test
    // 2-2 -> 3-2 Forty - Thirty
    public void shouldDisplayFortyThirtyAfterPlayer1ScoresAtThirtyThirty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreThirtyThirty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Forty - Thirty");
    }

    @Test
    // 2-3 -> WinPlayer2
    public void shouldDisplayWinForPlayer2AfterPlayer2ScoresAtThirtyForty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreThirtyForty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Win for player2");
    }

    @Test
    // 1-2 -> 1-3 Fifteen - Forty
    public void shouldDisplayFifteenFortyAfterPlayer2ScoresAtFifteenThirty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreFifteenThirty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Fifteen - Forty");
    }

    @Test
    // 1-3 -> 2-3 Thirty - Forty
    public void shouldDisplayThirtyFortyAfterPlayer1ScoresAtFifteenForty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreFifteenForty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Thirty - Forty");
    }

    @Test
    // 1-2 -> 2-2 Thirty - Thirty
    public void shouldDisplayThirtyThirtyAfterPlayer1ScoresAtFifteenThirty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreFifteenThirty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Thirty - Thirty");
    }

    @Test
    // 3-0 -> 3-1 Forty - Fifteen
    public void shouldDisplayFortyFifteenAfterPlayer2ScoresAtFortyLove() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreFortyLove());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Forty - Fifteen");
    }
    @Test
    // 3-1 -> 3-2 Forty - Thirty
    public void shouldDisplayFortyThirtyAfterPlayer2ScoresAtFortyFifteen() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreFortyFifteen());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Forty - Thirty");
    }

    @Test
    // 3-0 -> WinPlayer1
    public void shouldDisplayWinForPlayer1AfterPlayer1ScoresAtFortyLove() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreFortyLove());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Win for player1");
    }


    @Test
    // 3-1 -> Win for player1
    public void shouldDisplayWinForPlayer1WhenPlayer1ScoresAtFortyFifteen() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreFortyFifteen());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Win for player1");
    }

    @Test
    // 1-3 -> Win for player2
    public void shouldDisplayWinForPlayer2WhenPlayer2ScoresAtFifteenForty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreFifteenForty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Win for player2");
    }

    @Test
    // Deuce -> Advantage player1
    public void shouldDisplayAdvantagePlayer1AfterPlayer1ScoresAtDeuce() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreDeuce());
        //WHEN
        tg.wonPoint("player1");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Advantage player1");
    }


    @Test
    // Deuce -> Advantage player2
    public void shouldDisplayAdvantagePlayer2AfterPlayer2ScoresAtDeuce() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreDeuce());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Advantage player2");

    }

    @Test
    // 2-3 -> Deuce
    public void shouldDisplayDeuceAfterPlayer1ScoresAtThirtyForty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreThirtyForty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Deuce");
    }

    @Test
    // 3-2 -> Deuce
    public void shouldDisplayDeuceAfterPlayer2ScoresAtFortyThirty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreFortyThirty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Deuce");
    }

    @Test
    // 3-2 -> WinPlayer1
    public void shouldDisplayWinForPlayer1AfterPlayer1ScoresAtFortyThirty() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreFortyThirty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Win for player1");
    }

    @Test
    //  Advantage player1 -> Deuce
    public void shouldDisplayDeuceAfterPlayer2ScoresAtAdvantagePlayer1() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreAdvantagePlayer1());
        //WHEN
        tg.wonPoint("player2");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Deuce");
    }

    @Test
    //  Advantage player2 -> Deuce
    public void shouldDisplayDeuceAfterPlayer1ScoresAtAdvantagePlayer2() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreAdvantagePlayer2());
        //WHEN
        tg.wonPoint("player1");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Deuce");
    }

    @Test
    //  Advantage player1 -> WinPlayer1
    public void shouldDisplayWinPlayer1AfterPlayer1ScoresAtAdvantagePlayer1() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreAdvantagePlayer1());
        //WHEN
        tg.wonPoint("player1");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Win for player1");
    }

    @Test
    //  Advantage player2 -> WinPlayer2
    public void shouldDisplayWinPlayer2AfterPlayer2ScoresAtAdvantagePlayer2() {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreAdvantagePlayer2());
        //WHEN
        tg.wonPoint("player2");
        String score = tg.getScore();

        //THEN
        assertThat(score).isEqualTo("Win for player2");
    }

    @Test
    @Parameters({"player1", "player2"})
    //  WinPlayer1 -> WinPlayer1
    public void shouldDisplayWinPlayer1AfterAnyPlayerScoresAtWinPlayer1(String scoringPlayer) {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreWinForPlayer1());

        //WHEN
        tg.wonPoint(scoringPlayer);

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Win for player1");
    }

    @Test
    @Parameters({"player1", "player2"})
    //  WinPlayer2 -> WinPlayer2
    public void shouldDisplayWinPlayer2AfterAnyPlayerScoresAtWinPlayer2(String scoringPlayer) {
        //GIVEN
        TennisGame tg = new TennisGame();
        tg.setScore(new GameScoreWinForPlayer2());

        //WHEN
        tg.wonPoint(scoringPlayer);

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Win for player2");
    }

}