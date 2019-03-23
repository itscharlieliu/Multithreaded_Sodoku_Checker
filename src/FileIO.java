import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class FileIO {
  static String inputFromFile(String filePath) {
    Scanner fileInput;

    String outputString = "";
    try {
      fileInput = new Scanner(new FileReader(filePath));

      StringBuilder sb = new StringBuilder();

      while (fileInput.hasNext()){
        sb.append(fileInput.next()).append("\n");
      }
      outputString = sb.toString();
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + filePath);
    }
    return outputString;
  }
}
