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
    assertEquals("Test for Non Letter Character failed",false, ret);
    assertEquals("Test for number of letters left failed",3,normal.numLettersLeft);
    assertEquals("Test for number of guesses remaining failed",4, normal.guessesRemaining);
    assertEquals("Test for history seen failed","",normal.history);
    
  }
  
  @Test
  public void testLetterNotPresentCharacter() {
    normal = new NormalHangMan("HELL",4,"");
    boolean ret = normal.makeGuess('A');
    assertEquals("Test for Repeated Character failed",false,ret);
    assertEquals("Test for number of letters left failed",3, normal.numLettersLeft);
    assertEquals("Test for number of guesses remaining failed",3, normal.guessesRemaining);
    assertEquals("Test for history seen failed","A",normal.history);
    
    
  }
  
  @Test
  public void testLetterPresentCharacter() {
    normal = new NormalHangMan("HELL",4,"");
    boolean ret = normal.makeGuess('E');
    assertEquals("Test for  Character Present failed",ret, true);
    assertEquals("Test for number of letters left failed",normal.numLettersLeft, 2);
    assertEquals("Test for number of guesses remaining failed",normal.guessesRemaining, 4);
    assertEquals("Test for history seen failed",normal.history, "E");
     
  }
  @Test
  public void testRepeatedCharacter() {
    normal = new NormalHangMan("HELL",4,"A");
    boolean ret = normal.makeGuess('A');
    assertEquals("Test for Repeated Character failed",false,ret);
    assertEquals("Test for number of letters left failed",3, normal.numLettersLeft);
    assertEquals("Test for number of guesses remaining failed",4, normal.guessesRemaining);
    assertEquals("Test for history seen failed","A",normal.history);
     
  }

}
