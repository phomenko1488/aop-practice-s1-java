package homework.h04;

// advanced
// https://leetcode.com/problems/hamming-distance/
public class T2 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            xor &= (xor - 1);
            distance++;
        }
        return distance;
    }
}
