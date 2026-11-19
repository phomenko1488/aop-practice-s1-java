package homework.h12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class T2Tests {
    private T2 solver;

    @BeforeEach
    void setUp() {
        solver = new T2();
    }

    @Test
    @DisplayName("Базовий випадок з LeetCode #1: дублікати + залишкові елементи в кінці")
    void testStandardExample1() {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] expected = {2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19};
        assertArrayEquals(expected, solver.relativeSortArray(arr1, arr2));
    }

    @Test
    @DisplayName("Базовий випадок з LeetCode #2: усі елементи arr1 унікальні")
    void testStandardExample2() {
        int[] arr1 = {28, 6, 22, 8, 44, 17};
        int[] arr2 = {22, 28, 8, 6};
        int[] expected = {22, 28, 8, 6, 17, 44};
        assertArrayEquals(expected, solver.relativeSortArray(arr1, arr2));
    }

    @Test
    @DisplayName("Усі елементи arr1 присутні в arr2 (немає хвоста для сортування)")
    void testAllElementsPresentInArr2() {
        int[] arr1 = {5, 3, 1, 3, 5};
        int[] arr2 = {1, 5, 3};
        int[] expected = {1, 5, 5, 3, 3};
        assertArrayEquals(expected, solver.relativeSortArray(arr1, arr2));
    }

    @Test
    @DisplayName("Порожній arr2: масив arr1 повністю сортується за зростанням")
    void testEmptyArr2SortsAscending() {
        int[] arr1 = {9, 0, 5, 2, 0};
        int[] arr2 = {};
        int[] expected = {0, 0, 2, 5, 9};
        assertArrayEquals(expected, solver.relativeSortArray(arr1, arr2));
    }

    @Test
    @DisplayName("Граничні значення діапазону: 0 та 1000")
    void testBoundaryValues() {
        int[] arr1 = {1000, 0, 500, 1000, 0};
        int[] arr2 = {1000};
        int[] expected = {1000, 1000, 0, 0, 500};
        assertArrayEquals(expected, solver.relativeSortArray(arr1, arr2));
    }

    @Test
    @DisplayName("Один елемент в обох масивах")
    void testSingleElement() {
        int[] arr1 = {7};
        int[] arr2 = {7};
        assertArrayEquals(new int[]{7}, solver.relativeSortArray(arr1, arr2));
    }

    @Test
    @DisplayName("Захисна перевірка для null та порожнього вхідного масиву")
    void testNullAndEmptyInputs() {
        assertArrayEquals(new int[0], solver.relativeSortArray(null, new int[]{1, 2}));
        assertArrayEquals(new int[0], solver.relativeSortArray(new int[]{}, new int[]{1, 2}));
        assertArrayEquals(new int[]{1, 2, 3}, solver.relativeSortArray(new int[]{3, 1, 2}, null));
    }
}
