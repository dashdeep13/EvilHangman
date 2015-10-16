import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.net.httpserver.Authenticator.Success;


public class NormalHangManMakeGuessTest {
  NormalHangMan normal;
  
  
  @Test
  public void testNonLetterCharacter() {
    normal = new NormalHangMan("HELL",4,"");
    boolean ret = normal.makeGuess('$');
    assertEquals("Test for Non Letter Character failed",ret, false);
    assertEquals("Test for number of letters left",normal.numLettersLeft, 3);
    assertEquals("Test for number of guesses remaining",normal.guessesRemaining, 4);
    assertEquals("Test for history seen",normal.history, "");
    
  }
  
  @Test
  public void testRepeatedCharacter() {
    normal = new NormalHangMan("HELL",4,"");
    boolean ret = normal.makeGuess('A');
    ret = normal.makeGuess('A');
    assertEquals("Test for Repeated Character failed",ret, false);
    assertEquals("Test for number of letters left",normal.numLettersLeft, 3);
    assertEquals("Test for number of guesses remaining",normal.guessesRemaining, 3);
    assertEquals("Test for history seen",normal.history, "A");
    
    
  }
  
  @Test
  public void testLetterPresentCharacter() {
    normal = new NormalHangMan("HELL",4,"");
    boolean ret = normal.makeGuess('E');
    assertEquals("Test for  Character Present failed",ret, true);
    assertEquals("Test for number of letters left",normal.numLettersLeft, 2);
    assertEquals("Test for number of guesses remaining",normal.guessesRemaining, 4);
    assertEquals("Test for history seen",normal.history, "E");
    
    
  }

}
