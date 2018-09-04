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
        Game tg = new TennisGame();

        // WHEN THEN
        assertThat(tg.getScore()).isEqualTo("Love - Love");
    }

    @Test
    // 0-0 -> 1-0 Fifteen - Love
    public void shouldDisplayFifteenLoveAfterPlayerOneScoresAtLoveLove() {
        //GIVEN
        Game tg = new TennisGame();

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Fifteen - Love");
    }

    @Test
    // 0-0 -> 0-1 Love - Fifteen
    public void shouldDisplayLoveFifteenAfterPlayerOneScoresAtLoveLove() {
        //GIVEN
        Game tg = new TennisGame();

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Love - Fifteen");
    }

    @Test
    // 0-1 -> 1-1 Fifteen - Fifteen
    public void shouldDisplayFifteenFifteenAfterPlayer1ScoresAtLoveFifteen() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreLoveFifteen());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Fifteen - Fifteen");
    }

    @Test
    // 1-0 -> 1-1 Fifteen - Fifteen
    public void shouldDisplayFifteenFifteenAfterPlayer2ScoresAtFifteenLove() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFifteenLove());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        String score = tg.getScore();
        assertThat(score).isEqualTo("Fifteen - Fifteen");
    }


    @Test
    // 2-1 -> 2-2 Thirty - Thirty
    public void shouldDisplayThirtyThirtyAfterPlayer2ScoresAtThirtyFifteen() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreThirtyFifteen());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Thirty - Thirty");
    }

    @Test
    // 1-2 -> 2-2 Thirty - Thirty
    public void shouldDisplayThirtyThirtyAfterPlayer1ScoresAtFifteenThirty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFifteenThirty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Thirty - Thirty");
    }


    @Test
    // 1-1 -> 2-1 Thirty - Fifteen
    public void shouldDisplayThirtyFifteenAfterPlayer1ScoresAtFifteenFifteen() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFifteenFifteen());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Thirty - Fifteen");
    }

    @Test
    // 1-1 -> 1-2 Fifteen - Thirty
    public void shouldDisplayFifteenThirtyAfterPlayer2ScoresAtFifteenFifteen() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFifteenFifteen());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Fifteen - Thirty");
    }

    @Test
    // 0-1 -> 0-2 Love - Thirty
    public void shouldDisplayLoveThirtyAfterPlayer2ScoresAtLoveFifteen() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreLoveFifteen());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Love - Thirty");
    }

    @Test
    // 1-0 -> 2-0 Thirty - Love
    public void shouldDisplayThirtyLoveAfterPlayer1ScoresAtFifteenLove() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFifteenLove());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Thirty - Love");
    }

    @Test
    // 2-0 -> 3-0 Forty - Love
    public void shouldDisplayFortyLoveAfterPlayer1ScoresAtThirtyLove() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreThirtyLove());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Forty - Love");
    }

    @Test
    // 2-0 -> 2-1 Thirty - Fifteen
    public void shouldDisplayThirtyFifteenAfterPlayer2ScoresAtThirtyLove() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreThirtyLove());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Thirty - Fifteen");
    }

    @Test
    // 0-2 -> 0-3 Love - Forty
    public void shouldDisplayLoveFortyAfterPlayer2ScoresAtLoveThirty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreLoveThirty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Love - Forty");
    }

    @Test
    // 0-3 -> WinPlayer2
    public void shouldDisplayWinForPlayer2AfterPlayer2ScoresAtLoveForty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreLoveForty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Win for player2");
    }

    @Test
    // 0-3 -> WinPlayer2
    public void shouldDisplayFifteenFortyAfterPlayer1ScoresAtLoveForty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreLoveForty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Fifteen - Forty");
    }

    @Test
    // 0-2 -> 1-2 Fifteen - Thirty
    public void shouldDisplayFifteenThirtyAfterPlayer1ScoresAtLoveThirty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreLoveThirty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Fifteen - Thirty");
    }

    @Test
    // 2-1 -> 3-1 Forty - Fifteen
    public void shouldDisplayFortyFifteenAfterPlayer1ScoresAtThirtyFifteen() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreThirtyFifteen());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Forty - Fifteen");
    }

    @Test
    // 2-2 -> 2-3 Thirty - Forty
    public void shouldDisplayThirtyFortyAfterPlayer2ScoresAtThirtyThirty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreThirtyThirty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Thirty - Forty");
    }

    @Test
    // 2-2 -> 3-2 Forty - Thirty
    public void shouldDisplayFortyThirtyAfterPlayer1ScoresAtThirtyThirty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreThirtyThirty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Forty - Thirty");
    }

    @Test
    // 2-3 -> WinPlayer2
    public void shouldDisplayWinForPlayer2AfterPlayer2ScoresAtThirtyForty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreThirtyForty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Win for player2");
    }

    @Test
    // 1-2 -> 1-3 Fifteen - Forty
    public void shouldDisplayFifteenFortyAfterPlayer2ScoresAtFifteenThirty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFifteenThirty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Fifteen - Forty");
    }

    @Test
    // 1-3 -> 2-3 Thirty - Forty
    public void shouldDisplayThirtyFortyAfterPlayer1ScoresAtFifteenForty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFifteenForty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Thirty - Forty");
    }

    @Test
    // 3-0 -> 3-1 Forty - Fifteen
    public void shouldDisplayFortyFifteenAfterPlayer2ScoresAtFortyLove() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFortyLove());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Forty - Fifteen");
    }

    @Test
    // 3-1 -> 3-2 Forty - Thirty
    public void shouldDisplayFortyThirtyAfterPlayer2ScoresAtFortyFifteen() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFortyFifteen());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Forty - Thirty");
    }

    @Test
    // 3-0 -> WinPlayer1
    public void shouldDisplayWinForPlayer1AfterPlayer1ScoresAtFortyLove() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFortyLove());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Win for player1");
    }


    @Test
    // 3-1 -> Win for player1
    public void shouldDisplayWinForPlayer1WhenPlayer1ScoresAtFortyFifteen() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFortyFifteen());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Win for player1");
    }

    @Test
    // 1-3 -> Win for player2
    public void shouldDisplayWinForPlayer2WhenPlayer2ScoresAtFifteenForty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFifteenForty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Win for player2");
    }

    @Test
    // Deuce -> Advantage player1
    public void shouldDisplayAdvantagePlayer1AfterPlayer1ScoresAtDeuce() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreDeuce());
        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Advantage player1");
    }


    @Test
    // Deuce -> Advantage player2
    public void shouldDisplayAdvantagePlayer2AfterPlayer2ScoresAtDeuce() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreDeuce());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Advantage player2");

    }

    @Test
    // 2-3 -> Deuce
    public void shouldDisplayDeuceAfterPlayer1ScoresAtThirtyForty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreThirtyForty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Deuce");
    }

    @Test
    // 3-2 -> Deuce
    public void shouldDisplayDeuceAfterPlayer2ScoresAtFortyThirty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFortyThirty());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Deuce");
    }

    @Test
    // 3-2 -> WinPlayer1
    public void shouldDisplayWinForPlayer1AfterPlayer1ScoresAtFortyThirty() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreFortyThirty());

        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Win for player1");
    }

    @Test
    //  Advantage player1 -> Deuce
    public void shouldDisplayDeuceAfterPlayer2ScoresAtAdvantagePlayer1() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.advantagePlayer1());

        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Deuce");
    }

    @Test
    //  Advantage player2 -> Deuce
    public void shouldDisplayDeuceAfterPlayer1ScoresAtAdvantagePlayer2() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(new GameScoreAdvantagePlayer2());
        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Deuce");
    }

    @Test
    //  Advantage player1 -> WinPlayer1
    public void shouldDisplayWinPlayer1AfterPlayer1ScoresAtAdvantagePlayer1() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.advantagePlayer1());
        //WHEN
        tg.wonPoint("player1");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Win for player1");
    }

    @Test
    //  Advantage player2 -> WinPlayer2
    public void shouldDisplayWinPlayer2AfterPlayer2ScoresAtAdvantagePlayer2() {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(new GameScoreAdvantagePlayer2());
        //WHEN
        tg.wonPoint("player2");

        //THEN
        assertThat(tg.getScore()).isEqualTo("Win for player2");
    }

    @Test
    @Parameters({"player1", "player2"})
    //  WinPlayer1 -> WinPlayer1
    public void shouldDisplayWinPlayer1AfterAnyPlayerScoresAtWinPlayer1(String scoringPlayer) {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreWinForPlayer1());

        //WHEN
        tg.wonPoint(scoringPlayer);

        //THEN
        assertThat(tg.getScore()).isEqualTo("Win for player1");
    }

    @Test
    @Parameters({"player1", "player2"})
    //  WinPlayer2 -> WinPlayer2
    public void shouldDisplayWinPlayer2AfterAnyPlayerScoresAtWinPlayer2(String scoringPlayer) {
        //GIVEN
        Game tg = new TennisGame();
        tg.setScore(GameScores.createGameScoreWinForPlayer2());

        //WHEN
        tg.wonPoint(scoringPlayer);

        //THEN
        assertThat(tg.getScore()).isEqualTo("Win for player2");
    }

}