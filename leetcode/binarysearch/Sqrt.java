package leetcode.binarysearch;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("        System.out.println(\"args = \" + args);\n");
    }

    class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) {
                return x;
            }

            int right = x >= (int) Math.pow(2, 16) - 1 ? (int) Math.pow(2, 16) - 1 : x;
            int left = 1;
            while (left < right - 1) {
                int tmp = (left + right) / 2;
                if (tmp * tmp > x) {
                    right = tmp;
                } else if (tmp * tmp < x) {
                    left = tmp;
                } else {
                    return tmp;
                }
            }

            return left;
        }
    }
}
