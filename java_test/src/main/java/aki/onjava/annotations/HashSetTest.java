// annotations/HashSetTest.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java aki.onjava.onjava.atunit.AtUnit
// build/classes/java/main/annotations/HashSetTest.class}
package aki.onjava.annotations;
import java.util.*;
import aki.onjava.onjava.atunit.*;
import aki.onjava.onjava.*;

public class HashSetTest {
  HashSet<String> testObject = new HashSet<>();
  @Test
  void initialization() {
    assert testObject.isEmpty();
  }
  @Test
  void tContains() {
    testObject.add("one");
    assert testObject.contains("one");
  }
  @Test
  void tRemove() {
    testObject.add("one");
    testObject.remove("one");
    assert testObject.isEmpty();
  }
}
/* Output:
annotations.HashSetTest
  . tContains
  . initialization
  . tRemove
OK (3 tests)
*/
