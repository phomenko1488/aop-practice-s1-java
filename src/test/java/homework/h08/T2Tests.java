package homework.h08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
  @DisplayName("Базовий приклад з додатними та від'ємними числами")
  void testStandardExample() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(-1, 1, 2, 3, 1));
    int target = 2;
    assertEquals(3, solver.countPairs(nums, target));
  }

  @Test
  @DisplayName("Приклад з великою кількістю від'ємних чисел")
  void testWithNegativeNumbers() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(-6, 2, 5, -2, -7, -1, 3));
    int target = -2;
    assertEquals(10, solver.countPairs(nums, target));
  }

  @Test
  @DisplayName("Жодна пара не задовольняє умову")
  void testNoPairsMatch() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
    int target = 10;
    assertEquals(0, solver.countPairs(nums, target));
  }

  @Test
  @DisplayName("Усі пари задовольняють умову")
  void testAllPairsMatch() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));
    int target = 100;
    assertEquals(3, solver.countPairs(nums, target));
  }

  @Test
  @DisplayName("Граничні випадки: порожній список, один елемент або null")
  void testEdgeCases() {
    assertEquals(0, solver.countPairs(new ArrayList<>(), 5));
    assertEquals(0, solver.countPairs(new ArrayList<>(Collections.singletonList(1)), 5));
    assertEquals(0, solver.countPairs(null, 5));
  }

  @Test
  @DisplayName("Список з однаковими повторюваними числами")
  void testDuplicates() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(2, 2, 2, 2));
    int target = 5;
    // Кількість пар з 4 елементів: 4 * 3 / 2 = 6
    assertEquals(6, solver.countPairs(nums, target));
  }
}
