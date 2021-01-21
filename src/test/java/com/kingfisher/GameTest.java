package com.kingfisher;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;

public class GameTest {



    @Test
    public void whenGameStartShouldBeOnPosition1(){
        //Given the game is started
        //When the token is placed on the board
        Game game = new Game();
        //Then the token is on square 1
        Assert.assertThat(game.getCurrentPosition(),is(1));
    }

    /*Given the token is on square 1
    When the token is moved 3 spaces
    Then the token is on square 4*/
    @Test
    public void whenTokenMove3SpacesShouldBeOnPosition4(){
        //Given the token is on square 1
        Game game = new Game();
        //When the token is moved 3 spaces
        game.move(3);
        //Then the token is on square 4
        Assert.assertThat(game.getCurrentPosition(),is(4));
    }

    @Test
    public void whenTokenMove3SpacesAnd4ShouldBeOnPosition8() {
        //Given the token is on square 1
        Game game = new Game();
        //When the token is moved 3 spaces
        //And then it is moved 4 spaces
        game.move(3);
        game.move(4);
        //Then the token is on square 8
        Assert.assertThat(game.getCurrentPosition(),is(8));
    }

    @Test
    public void whenRollsDiceResultShouldBeBetween1And6(){
        //Given the game is started
        Game game = new Game();
        //When the player rolls a die
        int result =game.rollsDice();
        //Then the result should be between 1-6 inclusive
        Assert.assertThat(result >=1,is(true));
        Assert.assertThat(result<=6,is(true));
    }

    @Test
    public void whenRollsDice10TimesResultShouldBeBetween1And6(){
        //Given the game is started
        Game game = new Game();
        IntStream.range(0,10).forEach(value -> {
            int result =game.rollsDice();
            //Then the result should be between 1-6 inclusive
            Assert.assertThat(result >=1,is(true));
            Assert.assertThat(result<=6,is(true));
        });
    }

    @Test
    public void whenRollsDiceShouldMoveSameResult(){
        Game game = new Game();
        int result = game.rollsAndMove();
        Assert.assertThat(game.getCurrentPosition(),is(1+result));
    }

    //Given the token is on square 97
    //When the token is moved 3 spaces
    //Then the token is on square 100
    //And the player has won the game
    @Test
    public void whenPositionIs97AndMove3ShouldWin(){
        Game game = new Game();
        game.setCurrentPosition(97);

        game.move(3);
        Assert.assertThat(game.getCurrentPosition(),is(100));
        Assert.assertThat(game.isWon(),is(true));
    }

    @Test
    public void whenCurrentPositionIsNot100ShouldNotWin() {
        //Given the token is on square 97
        //When the token is moved 4 spaces
        //Then the token is on square 97
        //And the player has not won the game
        Game game = new Game();
        game.setCurrentPosition(97);
        game.move(4);
        game.setCurrentPosition(97);
        Assert.assertThat(game.isWon(),is(false));
    }



}
