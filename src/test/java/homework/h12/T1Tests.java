package homework.h12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T1Tests {
    private T1 solver;

    @BeforeEach
    void setUp() {
        solver = new T1();
    }

    @Test
    @DisplayName("Базовий випадок з LeetCode #1: [1,1,4,2,1,3] -> 3 розбіжності")
    void testStandardExample() {
        int[] heights = {1, 1, 4, 2, 1, 3};
        assertEquals(3, solver.heightChecker(heights));
    }

    @Test
    @DisplayName("Жоден учень не стоїть на своєму місці: [5,1,2,3,4] -> 5")
    void testAllMismatched() {
        int[] heights = {5, 1, 2, 3, 4};
        assertEquals(5, solver.heightChecker(heights));
    }

    @Test
    @DisplayName("Масив уже відсортований за неспаданням: [1,2,3,4,5] -> 0")
    void testAlreadySorted() {
        int[] heights = {1, 2, 3, 4, 5};
        assertEquals(0, solver.heightChecker(heights));
    }

    @Test
    @DisplayName("Усі учні мають однаковий зріст: [7,7,7,7] -> 0")
    void testAllEqualHeights() {
        int[] heights = {7, 7, 7, 7};
        assertEquals(0, solver.heightChecker(heights));
    }

    @Test
    @DisplayName("Граничні значення зросту (1 та 100)")
    void testBoundaryHeightValues() {
        int[] heights = {100, 1, 100, 1};
        // Очікується: [1, 1, 100, 100] -> розбіжності на індексах 0 та 3 (всього 2)
        assertEquals(2, solver.heightChecker(heights));
    }

    @Test
    @DisplayName("Граничні випадки довжини: null, порожній масив та один елемент")
    void testEdgeLengths() {
        assertEquals(0, solver.heightChecker(null));
        assertEquals(0, solver.heightChecker(new int[]{}));
        assertEquals(0, solver.heightChecker(new int[]{42}));
    }
}
