package homework.h02;

// base
// https://leetcode.com/problems/add-digits/
public class T1 {
  public int addDigits(int num) {
    if (num == 0) {
      return 0;
    }
    return 1 + (num - 1) % 9;
  }
}
