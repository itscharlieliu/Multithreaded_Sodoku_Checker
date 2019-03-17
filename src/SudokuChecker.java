public class SudokuChecker extends Thread {
  private SudokuItem[] sudokuSectionToBeChecked;

  SudokuChecker(SudokuItem[] sudokuSectionToBeChecked) {
    this.sudokuSectionToBeChecked = sudokuSectionToBeChecked;
  }

  public void run() {
    System.out.println("SudokuChecker running...");

  }

//  private boolean checkSudokuSection() {
//
//  }

}
