import java.util.LinkedList;
import java.util.List;

class SudokuCorrection {
  private List<SudokuItem> rowSuggestedCorrections;
  private List<SudokuItem> colSuggestedCorrections;
  private List<SudokuItem> boxSuggestedCorrections;

  private List<SudokuItem> finalCorrections;

  SudokuCorrection(
      List<SudokuItem> rowSuggestedCorrections,
      List<SudokuItem> colSuggestedCorrections,
      List<SudokuItem> boxSuggestedCorrections
  ) {
    this.rowSuggestedCorrections = rowSuggestedCorrections;
    this.colSuggestedCorrections = colSuggestedCorrections;
    this.boxSuggestedCorrections = boxSuggestedCorrections;
    finalCorrections = new LinkedList<>();
  }

  List<SudokuItem> getFinalCorrections() {
    for (SudokuItem rowSudokuItem: rowSuggestedCorrections) {

      System.out.println("Checking item: " + rowSudokuItem);
      if (
          rowSudokuItem.existsIn(colSuggestedCorrections)
              &&
              rowSudokuItem.existsIn(boxSuggestedCorrections)
      ) {
        setCorrection(rowSudokuItem);

        finalCorrections.add(rowSudokuItem);
      }
    }
    return finalCorrections;
  }


  // I am so sorry about these nested loops I know it is ugly
  // but it works and the performance loss is minimal for a 9x9 sudoku board
  private void setCorrection(SudokuItem rowSudokuItem) {
    for (int suggestedCorrections: rowSudokuItem.getSuggestedCorrection()) {
      for (SudokuItem colSudokuItem: colSuggestedCorrections) {
        // System.out.println("Comparing: " + rowSudokuItem + " and " + colSudokuItem);
        // System.out.println("IS equal: " + rowSudokuItem.equals(colSudokuItem));
        if (
            rowSudokuItem.equals(colSudokuItem)
                &&
                colSudokuItem.getSuggestedCorrection().contains(suggestedCorrections)
        ) {
          System.out.println("Column Checker contains: " + suggestedCorrections);
          for (SudokuItem boxSudokuItem: boxSuggestedCorrections) {
            if (
                boxSudokuItem.equals(rowSudokuItem)
                    &&
                    boxSudokuItem.getSuggestedCorrection().contains(suggestedCorrections)
            ) {
              System.out.println("Box Checker contains: " + suggestedCorrections);
              rowSudokuItem.setAsOnlyCorrection(suggestedCorrections);
            }
          }
        }
      }
    }
  }
}
