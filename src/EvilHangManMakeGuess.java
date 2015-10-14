import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.net.httpserver.Authenticator.Success;


public class EvilHangManMakeGuess {
  EvilHangMan evil;
  
  @Before
  public void initialize() {
    evil = new EvilHangMan(4, 4);
    String[] tempArray = {"BEDA","CEDA","PETA","CARD","TEAR"};
    evil.wordlist = tempArray;
    evil.numWords = evil.wordlist.length;
  }
  
  @Test
  public void testNonLetterCharacter() {
    
    boolean ret = evil.makeGuess('$');
    assertEquals(ret, false);
    
  }
  

  @Test
  public void testAllLetterCharacter() {
    boolean ret = evil.makeGuess('E');
    assertEquals("Test for false guess in Evil Hangman Failed",ret, false);
    ret = evil.makeGuess('A');
    assertEquals("Test for true guess in Evil Hangman(converted to Normal) Failed",ret, true);
  }
}
