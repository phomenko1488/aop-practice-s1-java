package homework.h08;

import java.util.List;

// advanced
// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
public class T2 {
  public int countPairs(List<Integer> nums, int target) {
    int result = 0;
    for (int i = 0; i < nums.size(); i++) {
      int first = nums.get(i);
      for (int j = i + 1; j < nums.size(); j++) {
        int second = nums.get(j);
        if (first + second < target) result++;
      }
    }
    return result;
  }
}
