import java.util.LinkedList;
import java.util.List;

public class BoxChecker extends Thread {

  private SudokuBoard sudokuBoard;
  private SudokuChecker[] sudokuChecker = new SudokuChecker[9];
  private List<SudokuItem> potentialErrorItems = new LinkedList<>();

  BoxChecker(SudokuBoard sudokuBoard) {
    this.sudokuBoard = sudokuBoard;
  }

  /**
   * BoxChecker.java
   * <p>
   * This class creates a thread to check for errors in the file in each 3x3 box.
   * </p>
   */

  public void run() {
    System.out.println("Box Checker running...");


    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; j++) {
        sudokuChecker[i] = new SudokuChecker(createSudokuBox(i, j));
        sudokuChecker[i].run();
        potentialErrorItems.addAll(sudokuChecker[i].getPotentialErrorItems());
      }
    }

    for (SudokuItem sudokuItem: potentialErrorItems) {
      System.out.println(
          "Box Checker Error at: "
              +
              sudokuItem
              +
              "; Suggested correction(s): "
              +
              sudokuItem.getSuggestedCorrection()
      );
    }
  }

  private SudokuItem[] createSudokuBox(int boxRow, int boxCol) {
    SudokuItem[] sudokuBox = new SudokuItem[9];

    if (boxRow >= 3 || boxCol >= 3 || boxRow < 0 || boxCol < 0) {
      System.out.println("Box Checker Error: Box row and box column must be between 0 and 2");
      return null;
    }

    int idx = 0;
    for (int row = 3 * boxRow; row < (3 * boxRow) + 3; ++row) {
      for (int col = 3 * boxCol; col < (3 * boxCol) + 3; ++col) {
        sudokuBox[idx] = sudokuBoard.getBoard()[row][col];
        ++idx;
      }
    }

    return sudokuBox;
  }

  List<SudokuItem> getPotentialErrorItems() {
    return potentialErrorItems;
  }

}
