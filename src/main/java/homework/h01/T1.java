package homework.h01;

// base
// https://leetcode.com/problems/smaalest-even-myltiple/
public class T1 {
  public int smallestEvenMultiple(int n) {
    return (n % 2 == 0) ? n : n * 2;
  }
}
