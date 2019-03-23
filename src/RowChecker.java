import java.util.LinkedList;
import java.util.List;

public class RowChecker extends Thread {

  private SudokuBoard sudokuBoard;
  private SudokuChecker[] sudokuChecker = new SudokuChecker[9];
  private List<SudokuItem> potentialErrorItems = new LinkedList<>();

  RowChecker(SudokuBoard sudokuBoard) {
    this.sudokuBoard = sudokuBoard;
  }

  /**
   * RowChecker.java
   * <p>
   * This class creates a thread to check for errors in the file row by row.
   * </p>
   */

  public void run() {

    System.out.println("Row Checker running...");

    for (int i = 0; i < 9; ++i) {
      sudokuChecker[i] = new SudokuChecker(sudokuBoard.getBoard()[i]);
      sudokuChecker[i].run();
      potentialErrorItems.addAll(sudokuChecker[i].getPotentialErrorItems());
    }

    for (SudokuItem sudokuItem: potentialErrorItems) {
      System.out.println(
          "Row Checker Error at: "
              +
              sudokuItem
              +
              "; Suggested correction(s): "
              +
              sudokuItem.getSuggestedCorrection()
      );
    }
  }

  List<SudokuItem> getPotentialErrorItems() {
    return potentialErrorItems;
  }
}
