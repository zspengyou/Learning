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

            int right = Integer.MAX_VALUE - 1;
            int left = 1;
            while (left < right - 1) {
                int tmp = (left + right) / 2;
                if (x / tmp < tmp) {
                    right = tmp;
                } else if (x / tmp > tmp) {
                    left = tmp;
                } else {
                    return tmp;
                }
            }

            return left;
        }
    }
}
