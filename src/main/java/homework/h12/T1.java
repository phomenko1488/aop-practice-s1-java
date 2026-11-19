package homework.h12;

// base
// https://leetcode.com/problems/height-checker/submissions/2199505759/
public class T1 {
  public int heightChecker(int[] heights) {
    if (heights == null || heights.length <= 1) {
      return 0;
    }

    int[] count = new int[101];
    for (int height : heights) {
      count[height]++;
    }

    int mismatches = 0;
    int currentHeight = 1;

    for (int height : heights) {
      while (count[currentHeight] == 0) {
        currentHeight++;
      }
      if (height != currentHeight) {
        mismatches++;
      }
      count[currentHeight]--;
    }

    return mismatches;
  }
}
