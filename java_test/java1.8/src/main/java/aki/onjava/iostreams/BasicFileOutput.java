package aki.onjava.iostreams;// iostreams/BasicFileOutput.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {VisuallyInspectOutput}

import java.io.*;

public class BasicFileOutput {
    static String file = "BasicFileOutput.dat";

    public static void main(String[] args) {
        try (
            //Reader: file -> FileReader ->BufferedReader -> StringReader -> BufferedReader
                BufferedReader in = new BufferedReader(
                        new StringReader(
                                BufferedInputFile.read("D:\\code\\cs\\spring_etc\\java_test\\src\\main\\java\\aki\\onjava\\iostreams\\BasicFileOutput.java")));


            //Writer: file -(StringReader)->  StringReader -> BufferedReader
                PrintWriter out = new PrintWriter(
                        new BufferedWriter(new FileWriter(file)))
        ) {
            in.lines().forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
}
