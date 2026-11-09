package homework.h09;

// base
// https://leetcode.com/problems/number-of-good-pairs/
public class T1 {
  public int numIdenticalPairs(int[] nums) {
    if (nums == null || nums.length < 2) {
      return 0;
    }

    int[] counts = new int[101];
    int goodPairs = 0;

    for (int num : nums) {
      goodPairs += counts[num];
      counts[num]++;
    }

    return goodPairs;
  }
}
