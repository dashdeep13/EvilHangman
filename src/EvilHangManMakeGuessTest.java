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
    assertEquals("Test to check letterGuess",evil.letterGuess, '$');
    assertEquals("Test to check letter history",evil.letterGuessHistory, "");
    assertEquals("Test to check number of guesses",evil.guess, 4);
    assertEquals("Test to check number of words",evil.guess, 4);
    assertEquals("Test to check non letter guess",ret, false);
    
  }
  

  @Test
  public void testAllLetterCharacterWrongGuess() {
    initialize();
    boolean ret = evil.makeGuess('E');
    assertEquals("Test for false guess in Evil Hangman Failed",ret, false);
    assertEquals("Test to check letterGuess",evil.letterGuess, 'E');
    assertEquals("Test to check letter history",evil.letterGuessHistory, "E");
    assertEquals("Test to check number of guesses",evil.guess, 3);
    assertEquals("Test to check number of words",evil.numWords, 1);
    
  }
  @Test
  public void testAllLetterCharacterCorrectGuess() {
    evil = new EvilHangMan(4, 4);
    String[] tempArray = {"CARD","TEAR"};
    evil.wordlist = tempArray;
    evil.numWords = evil.wordlist.length;
    boolean ret = evil.makeGuess('A');
    assertEquals("Test to check letter history",evil.letterGuessHistory, "");
    assertEquals("Test to check letterGuess",evil.letterGuess, 'A');
    assertEquals("Test to check number of guesses",evil.guess, 4);
    assertEquals("Test to check number of words",evil.numWords, 2);
    assertEquals("Test for true guess in Evil Hangman(converted to Normal) Failed",ret, true);
  }
}
