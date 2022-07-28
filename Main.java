import java.io.*;
import java.util.*;

class Main {
  private FileReader fileReader;
  private FileWriter fileWriter;
  public BufferedReader bufferedReader;
  public BufferedWriter bufferedWriter;
  public Scanner scanner;

  public Main() throws IOException {
    fileReader = new FileReader("input.txt");
    fileWriter = new FileWriter("output.txt");
    bufferedReader = new BufferedReader(fileReader);
    bufferedWriter = new BufferedWriter(fileWriter);
    scanner = new Scanner(System.in);
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();

    // list to store read lines from input.txt
    List<String> inputContent = new LinkedList<>();

    // read contents of input.txt
    String lineReader = "";
    while ((lineReader = main.bufferedReader.readLine()) != null) {
      inputContent.add(lineReader);
    }

    for (String str : inputContent) {
      System.out.println(str);
    }

  }
}