import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.net.httpserver.Authenticator.Success;


public class GUI_PlayGameControllerTest {
  GUI_PlayGame playGame;
  EvilHangMan evil;
  
 
  public void initialize() {
    playGame = new GUI_PlayGame(2, 3);
    evil = new EvilHangMan(2, 3);
    String[] tempArray = {"ED","CE","PE","CA","ER"};
    evil.wordlist = tempArray;
    evil.numWords = tempArray.length;
    playGame.game = evil;
    playGame.show();
 
  }
  
  @Test
  public void ChangetoNormalHangman() {
    initialize();
    playGame.inputLetter = 'E';
    playGame.controller();
    assertEquals("Test to change to Normal Hangman (result)",playGame.result.getText(), "Nope!");
    assertEquals("Test to check number of guesses remaining(label3)",playGame.label3.getText(), "Guesses Remaining: " + playGame.game.numGuessesRemaining());
    assertEquals("Test to check value of label 2 ","Secret Word: "+playGame.game.displayGameState(), playGame.label2.getText());
  }
  
//  @Test
//  public void GameOverIncorrectGuesses() {
//    initialize();
//    playGame.inputLetter = 'L';
//    playGame.controller();
//    playGame.inputLetter = 'S';
//    playGame.controller();
//    playGame.inputLetter = 'P';
//    playGame.controller();
//    assertEquals("Test to check for Game over with wrong guesses",playGame.game.isWin(), false);
//    assertEquals("Test to check value of label 2 ","Secret Word: "+playGame.game.displayGameState(), playGame.label2.getText());
//    assertEquals("Test to check number of guesses remaining(label3)",playGame.label3.getText(), "Guesses Remaining: " + playGame.game.numGuessesRemaining());
//  }
  
  @Test
  public void GameOverIncorrectGuesses() {
    playGame = new GUI_PlayGame(2, 3);
    evil = new EvilHangMan(2, 1);
    String[] tempArray = {"ED","CE","PE","CA","ER"};
    evil.wordlist = tempArray;
    evil.numWords = tempArray.length;
    playGame.game = evil;
    playGame.show();
    playGame.inputLetter = 'L';
    playGame.controller();
    assertEquals("Test to check for Game over with wrong guesses",playGame.game.isWin(), false);
    assertEquals("Test to check value of label 2 ","Secret Word: "+playGame.game.displayGameState(), playGame.label2.getText());
    assertEquals("Test to check number of guesses remaining(label3)",playGame.label3.getText(), "Guesses Remaining: " + playGame.game.numGuessesRemaining());
  }
  
  @Test
  public void GameOverCorrectGuess() {
    initialize();
    playGame.inputLetter = 'E';
    playGame.controller();
    playGame.inputLetter = 'A';
    playGame.controller();
    playGame.inputLetter = 'C';
    playGame.controller();
    assertEquals("Test to check for Game over with right guesses",playGame.game.isWin(), true);
    assertEquals("Test to check number of guesses remaining(label3)",playGame.label3.getText(), "Guesses Remaining: " + playGame.game.numGuessesRemaining());
    assertEquals("Test to check value of label 2 ","Secret Word: "+playGame.game.displayGameState(), playGame.label2.getText());
        
  }
  
  
}
