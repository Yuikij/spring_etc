package aki.onjava.iostreams;// iostreams/FileOutputShortcut.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {VisuallyInspectOutput}
import java.io.*;

public class FileOutputShortcut {
  static String file = "FileOutputShortcut.dat";
  public static void main(String[] args) {
    try(
      BufferedReader in = new BufferedReader(
        new StringReader(BufferedInputFile.read(
          "D:\\code\\cs\\spring_etc\\java_test\\src\\main\\java\\aki\\onjava\\iostreams\\FileOutputShortcut.java")));
      // Here's the shortcut:
      PrintWriter out = new PrintWriter(file)
    ) {
      in.lines().forEach(out::println);
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(BufferedInputFile.read(file));
  }
}
