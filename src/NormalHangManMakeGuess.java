import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.net.httpserver.Authenticator.Success;


public class NormalHangManMakeGuess {
  NormalHangMan normal;
  
  
  @Test
  public void testNonLetterCharacter() {
    normal = new NormalHangMan("HELL",4,"");
    boolean ret = normal.makeGuess('$');
    assertEquals("Test for Non Letter Character failed",ret, false);
    
  }
  
  @Test
  public void testRepeatedCharacter() {
    normal = new NormalHangMan("HELL",4,"");
    boolean ret = normal.makeGuess('A');
    ret = normal.makeGuess('A');
    assertEquals("Test for Repeated Character failed",ret, false);
    
  }
  
  @Test
  public void testLetterPresentCharacter() {
    normal = new NormalHangMan("HELL",4,"");
    boolean ret = normal.makeGuess('E');
    assertEquals("Test for  Character Present failed",ret, true);
    
  }

}
