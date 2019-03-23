import java.util.LinkedList;
import java.util.List;

class SudokuChecker {
  private SudokuItem[] sudokuSectionToBeChecked;
  private List<SudokuItem> potentialErrorItems = new LinkedList<>();

  //  lists the amount of times each number got used in a section
  private short[] numbersUsedAmount = new short[10];


  SudokuChecker(SudokuItem[] sudokuSectionToBeChecked) {
    this.sudokuSectionToBeChecked = sudokuSectionToBeChecked;
  }

  void run() {
    System.out.println("SudokuChecker running...");

    if (sudokuSectionToBeChecked.length != 9) {
      System.out.println(
          "Sudoku section length incorrect. Expect 9, got "
              +
              sudokuSectionToBeChecked.length);
      return;
    }

    //  printing the selection that we passed through
    System.out.println("Checking selection: ");
    for (int i = 0; i < 9; ++i) {
      System.out.println(sudokuSectionToBeChecked[i]);
    }

    for (int i = 0; i < 9; ++i) {
      SudokuItem curr = sudokuSectionToBeChecked[i];
      numbersUsedAmount[curr.getValue()]++;
      for (int j = i - 1; j >= 0; --j) {
        // System.out.println(
        //    "Curr: " + curr + ", checking against: " + sudokuSectionToBeChecked[j]
        // );
        if (curr.getValue() == sudokuSectionToBeChecked[j].getValue()) {

          SudokuItem temp1 = new SudokuItem(curr);
          SudokuItem temp2 = new SudokuItem(sudokuSectionToBeChecked[j]);

          // add both to the potential error list
          potentialErrorItems.add(temp1);
          potentialErrorItems.add(temp2);
        }
      }
    }

    suggestCorrections();

    System.out.println("Times each number was used:");
    for (int i = 1; i < 10; ++i) {
      System.out.print(numbersUsedAmount[i]);
    }
    System.out.println();


  }

  private void suggestCorrections() {
    for (SudokuItem sudokuItem: potentialErrorItems) {
      for (int k = 1; k < 10; ++k) {
        // System.out.println(k + " used " + numbersUsedAmount[k] + " times.");
        if (numbersUsedAmount[k] == 0) {
          sudokuItem.setSuggestedCorrection(k);
        }
      }
    }
  }

  List<SudokuItem> getPotentialErrorItems() {
    return potentialErrorItems;
  }
}
