import java.util.List;

public class Main {
  
  /**
   * Main.java
   * <p>
   * This Program gets a 9x9 sudoku board as input and checks for errors.
   * If errors exist, a possible solution is provided*
   * </p>
   */

  public static void main(String[] args) {
    System.out.println("Starting Sudoku Checker...");

    if (args.length == 0) {
      System.out.println("Please input file path as an argument");
      System.out.println("Example: ./input/test1.txt");
      return;
    }

    SudokuBoard sudokuBoard = new SudokuBoard(args[0]);

    RowChecker rowChecker = new RowChecker(sudokuBoard);
    ColumnChecker columnChecker = new ColumnChecker(sudokuBoard);
    BoxChecker boxChecker = new BoxChecker(sudokuBoard);

    rowChecker.start();
    columnChecker.start();
    boxChecker.start();


    try {
      rowChecker.join();
      columnChecker.join();
      boxChecker.join();
    } catch (InterruptedException e) {
      System.out.println("Error: Interrupted Exception");
    }

    SudokuCorrection sudokuCorrection = new SudokuCorrection(
        rowChecker.getPotentialErrorItems(),
        columnChecker.getPotentialErrorItems(),
        boxChecker.getPotentialErrorItems()
        );

    List<SudokuItem> finalCorrections = sudokuCorrection.getFinalCorrections();
    System.out.println("-------------------------------------------------------------------------");
    for (SudokuItem sudokuItem: finalCorrections) {
      System.out.println("Final Answer: " + sudokuItem);
    }
  }
}
