package homework.h16;

// advanced
// https://leetcode.com/problems/find-the-town-judge/description/
public class T2 {
  public int findJudge(int n, int[][] trust) {
    if (n <= 0) {
      return -1;
    }
    if (trust == null || trust.length < n - 1) {
      return -1;
    }

    int[] trustScore = new int[n + 1];
    for (int[] relation : trust) {
      trustScore[relation[0]]--;
      trustScore[relation[1]]++;
    }

    for (int person = 1; person <= n; person++) {
      if (trustScore[person] == n - 1) {
        return person;
      }
    }

    return -1;
  }
}
