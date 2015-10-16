import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.net.httpserver.Authenticator.Success;


public class EvilHangManMakeGuessTest {
  EvilHangMan evil;
  
  public void initialize() {
    evil = new EvilHangMan(4, 4);
    String[] tempArray = {"BEDA","CEDA","PETA","CARD","TEAR"};
    evil.wordlist = tempArray;
    evil.numWords = evil.wordlist.length;
   
  }
  
  @Test
  public void testNonLetterCharacter() {
    initialize();
    boolean ret = evil.makeGuess('$');
    assertEquals("Test to check letterGuess failed",'$', evil.letterGuess );
    assertEquals("Test to check letter history failed", "",evil.letterGuessHistory);
    assertEquals("Test to check number of guesses failed",4, evil.guess);
    assertEquals("Test to check number of words failed",5, evil.numWords);
    assertEquals("Test to check non letter guess failed",false, ret);
    
    
  }
  

  @Test
  public void testAllLetterCharacterWrongGuess() {
    initialize();
    boolean ret = evil.makeGuess('E');
    assertEquals("Test for false guess in Evil Hangman Failed",false,ret);
    assertEquals("Test to check letterGuess failed",evil.letterGuess, 'E');
    assertEquals("Test to check letter history failed","E", evil.letterGuessHistory );
    assertEquals("Test to check number of guesses failed",3, evil.guess);
    assertEquals("Test to check number of words failed", 1,evil.numWords);
    
  }
  @Test
  public void testAllLetterCharacterCorrectGuess() {
    evil = new EvilHangMan(4, 4);
    String[] tempArray = {"CARD","TEAR"};
    evil.wordlist = tempArray;
    evil.numWords = evil.wordlist.length;
    boolean ret = evil.makeGuess('R');
    assertEquals("Test to check letter history failed", "", evil.letterGuessHistory);
    assertEquals("Test to check letterGuess failed",'R',evil.letterGuess);
    assertEquals("Test to check number of guesses failed",4, evil.guess);
    assertEquals("Test to check number of words failed",2,evil.numWords);
    assertEquals("Test for true guess in Evil Hangman(converted to Normal) Failed",true,ret);
  }
}
