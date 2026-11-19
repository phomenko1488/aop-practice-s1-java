package homework.h16;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class T1Tests {
  private T1 solver;

  @BeforeEach
  void setUp() {
    solver = new T1();
  }

  @Test
  @DisplayName(
      "Базовий випадок з LeetCode #1: заливка 4-зв'язної області (діагональний піксель лишається незмінним)")
  void testStandardExample1() {
    int[][] image = {
      {1, 1, 1},
      {1, 1, 0},
      {1, 0, 1}
    };
    int[][] expected = {
      {2, 2, 2},
      {2, 2, 0},
      {2, 0, 1}
    };

    assertArrayEquals(expected, solver.floodFill(image, 1, 1, 2));
  }

  @Test
  @DisplayName(
      "Базовий випадок з LeetCode #2: новий колір збігається з початковим (захист від зациклення)")
  void testSameTargetColor() {
    int[][] image = {
      {0, 0, 0},
      {0, 0, 0}
    };
    int[][] expected = {
      {0, 0, 0},
      {0, 0, 0}
    };

    assertArrayEquals(expected, solver.floodFill(image, 0, 0, 0));
  }

  @Test
  @DisplayName("Ізольований стартовий піксель, оточений іншими кольорами")
  void testIsolatedSinglePixel() {
    int[][] image = {
      {5, 5, 5},
      {5, 1, 5},
      {5, 5, 5}
    };
    int[][] expected = {
      {5, 5, 5},
      {5, 9, 5},
      {5, 5, 5}
    };

    assertArrayEquals(expected, solver.floodFill(image, 1, 1, 9));
  }

  @Test
  @DisplayName("Матриця розміром 1x1")
  void testSingleCellGrid() {
    int[][] image = {{3}};
    int[][] expected = {{7}};

    assertArrayEquals(expected, solver.floodFill(image, 0, 0, 7));
  }

  @Test
  @DisplayName("Заливка починається з кутової клітинки та охоплює весь ланцюжок")
  void testCornerStartFullChain() {
    int[][] image = {
      {1, 1, 2},
      {0, 1, 2},
      {0, 1, 1}
    };
    int[][] expected = {
      {4, 4, 2},
      {0, 4, 2},
      {0, 4, 4}
    };

    assertArrayEquals(expected, solver.floodFill(image, 0, 0, 4));
  }

  @Test
  @DisplayName("Граничні випадки: null або порожня матриця")
  void testNullAndEmptyMatrix() {
    assertNull(solver.floodFill(null, 0, 0, 1));
    int[][] emptyRows = new int[0][0];
    assertArrayEquals(emptyRows, solver.floodFill(emptyRows, 0, 0, 1));
    int[][] emptyCols = new int[2][0];
    assertArrayEquals(emptyCols, solver.floodFill(emptyCols, 0, 0, 1));
  }
}
