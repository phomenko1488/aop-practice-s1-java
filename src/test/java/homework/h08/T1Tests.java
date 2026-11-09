package homework.h08;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  @DisplayName("Базовий приклад: чергування нулів та одиниць")
  void testStandardCase() {
    int[] nums = {1, 1, 0, 1, 1, 1};
    assertEquals(3, solver.findMaxConsecutiveOnes(nums));
  }

  @Test
  @DisplayName("Одиниці розташовані на початку або всередині")
  void testAlternatingSequence() {
    int[] nums = {1, 0, 1, 1, 0, 1};
    assertEquals(2, solver.findMaxConsecutiveOnes(nums));
  }

  @Test
  @DisplayName("Масив містить лише одиниці")
  void testAllOnes() {
    int[] nums = {1, 1, 1, 1, 1};
    assertEquals(5, solver.findMaxConsecutiveOnes(nums));
  }

  @Test
  @DisplayName("Масив містить лише нулі")
  void testAllZeros() {
    int[] nums = {0, 0, 0, 0};
    assertEquals(0, solver.findMaxConsecutiveOnes(nums));
  }

  @Test
  @DisplayName("Одиничний елемент: [1] та [0]")
  void testSingleElement() {
    assertEquals(1, solver.findMaxConsecutiveOnes(new int[] {1}));
    assertEquals(0, solver.findMaxConsecutiveOnes(new int[] {0}));
  }

  @Test
  @DisplayName("Граничні випадки: порожній масив або null")
  void testEmptyAndNull() {
    assertEquals(0, solver.findMaxConsecutiveOnes(new int[] {}));
    assertEquals(0, solver.findMaxConsecutiveOnes(null));
  }

  @Test
  @DisplayName("Одиниці розташовані лише в кінці")
  void testOnesAtTheEnd() {
    int[] nums = {0, 0, 1, 1, 1, 1};
    assertEquals(4, solver.findMaxConsecutiveOnes(nums));
  }
}
