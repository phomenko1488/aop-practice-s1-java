package homework.h09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// advanced
// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies
public class T2 {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    if (candies == null || candies.length == 0) {
      return Collections.emptyList();
    }

    int maxCandies = 0;
    for (int candy : candies) {
      if (candy > maxCandies) {
        maxCandies = candy;
      }
    }

    List<Boolean> result = new ArrayList<>(candies.length);
    for (int candy : candies) {
      result.add(candy + extraCandies >= maxCandies);
    }

    return result;
  }
}
