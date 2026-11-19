package homework.h16;

// base
// https://leetcode.com/problems/flood-fill/description/
public class T1 {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    if (image == null || image.length == 0 || image[0].length == 0) {
      return image;
    }

    int originalColor = image[sr][sc];
    if (originalColor != color) {
      dfs(image, sr, sc, originalColor, color);
    }

    return image;
  }

  private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
    if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
      return;
    }
    if (image[row][col] != originalColor) {
      return;
    }

    image[row][col] = newColor;

    dfs(image, row - 1, col, originalColor, newColor);
    dfs(image, row + 1, col, originalColor, newColor);
    dfs(image, row, col - 1, originalColor, newColor);
    dfs(image, row, col + 1, originalColor, newColor);
  }
}
