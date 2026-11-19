package homework.h12;

// advanced
// https://leetcode.com/problems/relative-sort-array/
public class T2 {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    if (arr1 == null || arr1.length == 0) {
      return new int[0];
    }

    int[] count = new int[1001];
    for (int num : arr1) {
      count[num]++;
    }

    int[] result = new int[arr1.length];
    int index = 0;

    if (arr2 != null) {
      for (int num : arr2) {
        while (count[num] > 0) {
          result[index++] = num;
          count[num]--;
        }
      }
    }

    for (int num = 0; num < count.length; num++) {
      while (count[num] > 0) {
        result[index++] = num;
        count[num]--;
      }
    }

    return result;
  }
}
