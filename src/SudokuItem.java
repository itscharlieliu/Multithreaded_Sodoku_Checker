public class SudokuItem {
  private int value;
  private int x;
  private int y;

  SudokuItem(int value, int x, int y) {
    this.value = value;
    this.x = x;
    this.y = y;
  }

  int getValue() {
    return value;
  }

  int getX() {
    return x;
  }

  int getY() {
    return y;
  }

}
