package homework.h10;

// base
// https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/
public class T1 {
  public char kthCharacter(int k) {
    if (k == 1) {
      return 'a';
    }

    int highestPower = Integer.highestOneBit(k - 1);
    char previousChar = kthCharacter(k - highestPower);
    return (char) ((previousChar - 'a' + 1) % 26 + 'a');
  }
}
