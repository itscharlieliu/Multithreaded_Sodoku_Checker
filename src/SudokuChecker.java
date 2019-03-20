import java.util.LinkedList;
import java.util.List;

public class SudokuChecker {
  private SudokuItem[] sudokuSectionToBeChecked;
  private List<SudokuItem> potentialErrorItems = new LinkedList<>();

//  lists the amount of times each number got used in a section
  private short[] numbersUsedAmount = new short[10];


  SudokuChecker(SudokuItem[] sudokuSectionToBeChecked) {
    this.sudokuSectionToBeChecked = sudokuSectionToBeChecked;
  }

  public void run() {
    System.out.println("SudokuChecker running...");

    if (sudokuSectionToBeChecked.length != 9)
    {
      System.out.println("Sudoku section length incorrect. Expect 9, got " + sudokuSectionToBeChecked.length);
      return;
    }

//  printing the selection that we passed through
    System.out.print("Checking selection: ");
    for (int i = 0; i < 9; ++i) {
      System.out.print(sudokuSectionToBeChecked[i]);
    }
    System.out.println();

    for (int i = 0; i < 9; ++i)
    {
      SudokuItem curr = sudokuSectionToBeChecked[i];
      numbersUsedAmount[curr.getValue()]++;
      for (int j = i - 1; j > 0; --j) {
        System.out.println("Curr: " + curr + ", checking against: " + sudokuSectionToBeChecked[j]);
        if (curr.getValue() == sudokuSectionToBeChecked[j].getValue()) {
          // add both to the potential error list
          potentialErrorItems.add(curr);
          potentialErrorItems.add(sudokuSectionToBeChecked[j]);
          System.out.println("Error at: " + curr.getX() + ", " + curr.getY());
        }
      }
    }

    System.out.println("Times each number was used:");
    for (int i = 1; i < 10; ++i) {
      System.out.print(numbersUsedAmount[i]);
      if (numbersUsedAmount[i] > 1) {

      }
    }


  }

  public List<SudokuItem> getPotentialErrorItems() {
    return potentialErrorItems;
  }

//  private boolean checkSudokuSection() {
//
//  }

}
