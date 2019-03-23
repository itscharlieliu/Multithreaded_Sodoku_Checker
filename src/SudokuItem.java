import java.util.LinkedList;
import java.util.List;

public class SudokuItem {
  private int value;
  private int row;
  private int col;
  private List<Integer> suggestedCorrection;

  /**
   * SudokuItem.java
   * <p>
   * This class provides getters and setters for the value of a sudoku item
   * and its coordinates on the 9x9 grid.
   * </p>
   */

  SudokuItem(int value, int row, int col) {
    this.value = value;
    this.row = row;
    this.col = col;
    suggestedCorrection = new LinkedList<>();
  }

  SudokuItem(SudokuItem sudokuItem) {
    this.value = sudokuItem.getValue();
    this.row = sudokuItem.getRow();
    this.col = sudokuItem.getCol();
    suggestedCorrection = new LinkedList<>();
  }

  int getValue() {
    return value;
  }

  private int getRow() {
    return row;
  }

  private int getCol() {
    return col;
  }

  /**
   * Creates a string from its value and coordinates.
   * @return The sudoku item as a string
   */

  public String toString() {
    return
        "Value: "
            +
            getValue()
            +
            "; Coordinates: "
            +
            getRow()
            +
            ", "
            +
            getCol()
            +
            "; Suggested Correction(s): "
            +
            getSuggestedCorrection();
  }

  void setSuggestedCorrection(int suggestedCorrection) {
    this.suggestedCorrection.add(suggestedCorrection);
  }

  void setAsOnlyCorrection(int suggestedCorrection) {
    this.suggestedCorrection = new LinkedList<>();
    this.suggestedCorrection.add(suggestedCorrection);
  }

  List<Integer> getSuggestedCorrection() {
    return suggestedCorrection;
  }

  boolean equals(SudokuItem sudokuItem) {
    return
        this.getValue() == sudokuItem.getValue()
            &&
            this.getRow() == sudokuItem.getRow()
            &&
            this.getCol() == sudokuItem.getCol();
  }

  boolean existsIn(List<SudokuItem> list) {
    for (SudokuItem sudokuItem: list) {
      if (this.equals(sudokuItem)) {
        return true;
      }
    }
    return false;
  }
}
