// annotations/Testable.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package aki.onjava.annotations;
import aki.onjava.onjava.atunit.*;

public class Testable {
  public void execute() {
    System.out.println("Executing..");
  }
  @Test
  void testExecute() { execute(); }
}
