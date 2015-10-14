import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.net.httpserver.Authenticator.Success;


public class GUI_PlayGameController {
  GUI_PlayGame playGame;
  EvilHangMan evil;
  
  @Before
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
    
    playGame.inputLetter = 'E';
    playGame.controller();
        
  }
  
  @Test
  public void GameOverIncorrectGuesses() {
    
    playGame.inputLetter = 'L';
    playGame.controller();
    playGame.inputLetter = 'S';
    playGame.controller();
    playGame.inputLetter = 'P';
    playGame.controller();
    
  }
  
  @Test
  public void GameOverCorrectGuess() {
    
    playGame.inputLetter = 'E';
    playGame.controller();
    playGame.inputLetter = 'A';
    playGame.controller();
    playGame.inputLetter = 'C';
    playGame.controller();
        
  }
  
}
