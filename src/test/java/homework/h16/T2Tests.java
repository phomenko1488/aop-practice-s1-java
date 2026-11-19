package homework.h16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class T2Tests {
  private T2 solver;

  @BeforeEach
  void setUp() {
    solver = new T2();
  }

  @Test
  @DisplayName("Базовий випадок #1: n = 2, [[1, 2]] -> суддя 2")
  void testTwoPeopleOneTrust() {
    int[][] trust = {{1, 2}};
    assertEquals(2, solver.findJudge(2, trust));
  }

  @Test
  @DisplayName("Базовий випадок #2: n = 3, [[1, 3], [2, 3]] -> суддя 3")
  void testThreePeopleJudgeExists() {
    int[][] trust = {{1, 3}, {2, 3}};
    assertEquals(3, solver.findJudge(3, trust));
  }

  @Test
  @DisplayName("Базовий випадок #3: суддя порушує правило і комусь довіряє (цикл довіри)")
  void testJudgeTrustsSomeoneReturnsMinusOne() {
    int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
    assertEquals(-1, solver.findJudge(3, trust));
  }

  @Test
  @DisplayName("Місто з 1 мешканцем і порожнім списком довіри -> суддя 1")
  void testSingleResidentNoTrust() {
    assertEquals(1, solver.findJudge(1, new int[0][0]));
  }

  @Test
  @DisplayName("Кілька мешканців, але зв'язків довіри замало для виявлення судді")
  void testInsufficientTrustRelations() {
    int[][] trust = {{1, 2}};
    assertEquals(-1, solver.findJudge(3, trust));
  }

  @Test
  @DisplayName("Складний граф із 4 людей, де один не довіряє кандидату")
  void testFourPeopleMissingOneVote() {
    int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
    // 3 отримує голоси від 1, 2 та 4 (всього 3 = n - 1) і нікому не довіряє
    assertEquals(3, solver.findJudge(4, trust));
  }

  @Test
  @DisplayName("Граничні випадки: некоректне n <= 0 або null масив довіри")
  void testEdgeCases() {
    assertEquals(-1, solver.findJudge(0, new int[0][0]));
    assertEquals(-1, solver.findJudge(-5, new int[0][0]));
    assertEquals(-1, solver.findJudge(2, null));
  }
}
