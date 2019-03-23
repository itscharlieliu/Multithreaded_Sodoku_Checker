
class SudokuBoard {
  private SudokuItem[][] board = null;

  SudokuBoard(String filePath) {
    initBoard(filePath);
    printBoard();
  }

  private void initBoard(String filePath) {
    String[] boardArrayFromInput = FileIO.inputFromFile(filePath).split("[,\n]");

    if (boardArrayFromInput.length != 89) {
      System.out.println(
          "Input file syntax error: input must contain a 9 by 9 board delimited by commas."
      );
      return;
    }

    SudokuItem[][] tempBoard = new SudokuItem[9][9];

    int boardArrayIdx = 0;
    for (int row = 0; row < 9; ++row) {
      for (int col = 0; col < 9; ++col) {
        tempBoard[row][col] = new SudokuItem(
            Integer.valueOf(boardArrayFromInput[boardArrayIdx]),
            col + 1,
            row + 1
        );
        ++boardArrayIdx;
      }
      ++boardArrayIdx;
    }

    board = tempBoard;
  }

  private void printBoard() {
    if (board != null) {
      for (int rowIdx = 0; rowIdx < 9; ++rowIdx) {
        for (int colIdx = 0; colIdx < 9; ++colIdx) {
          System.out.print(board[rowIdx][colIdx].getValue());
        }
        System.out.print("\n");
      }
    }
  }

  SudokuItem[][] getBoard() {
    return board;
  }
}
