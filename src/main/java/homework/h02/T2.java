package homework.h02;

// advanced
// https://leetcode.com/problems/is-same-after-reversals/
public class T2 {
  public boolean isSameAfterReversals(int num) {
    return num == 0 || num % 10 != 0;
  }
}
