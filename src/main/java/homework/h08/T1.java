package homework.h08;

// base
// https://leetcode.com/problems/max-consecutive-ones/
public class T1 {
  public int findMaxConsecutiveOnes(int[] nums) {
    int maxConsecutive = 0;
    int currentConsecutive = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        currentConsecutive++;
        if (currentConsecutive > maxConsecutive) maxConsecutive = currentConsecutive;
      } else currentConsecutive = 0;
    }
    return maxConsecutive;
  }
}
