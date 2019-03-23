import java.util.LinkedList;
import java.util.List;

public class ColumnChecker extends Thread {
  private SudokuBoard sudokuBoard;
  private SudokuChecker[] sudokuChecker = new SudokuChecker[9];
  private List<SudokuItem> potentialErrorItems = new LinkedList<>();

  ColumnChecker(SudokuBoard sudokuBoard) {
    this.sudokuBoard = sudokuBoard;
  }

  /**
   * ColumnChecker.java
   * <p>
   * This class creates a thread to check for errors in the file column by column.
   * </p>
   */

  public void run() {
    System.out.println("Column Checker running...");

    for (int i = 0; i < 9; ++i) {
      SudokuItem[] column = new SudokuItem[9];
      for (int j = 0; j < 9; ++j) {
        column[j] = sudokuBoard.getBoard()[j][i];
      }
      sudokuChecker[i] = new SudokuChecker(column);
      sudokuChecker[i].run();
      potentialErrorItems.addAll(sudokuChecker[i].getPotentialErrorItems());
    }

    for (SudokuItem sudokuItem: potentialErrorItems) {
      System.out.println(
          "Column Checker Error at: "
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
