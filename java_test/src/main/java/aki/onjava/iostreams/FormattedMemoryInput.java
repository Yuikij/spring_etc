package aki.onjava.iostreams;// iostreams/FormattedMemoryInput.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {VisuallyInspectOutput}
import java.io.*;

public class FormattedMemoryInput {
  public static void main(String[] args) {
    try(
      DataInputStream in = new DataInputStream(
        new ByteArrayInputStream(
          BufferedInputFile.read(
            "D:\\code\\cs\\spring_etc\\java_test\\src\\main\\java\\aki\\onjava\\iostreams\\FormattedMemoryInput.java")
              .getBytes()))
    ) {
      while(true)
        System.out.write((char)in.readByte());
    } catch(EOFException e) {
      System.out.println("\nEnd of stream");
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
}
