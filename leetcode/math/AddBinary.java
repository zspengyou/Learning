package leetcode.math;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println("https://leetcode.com/problems/add-binary/");
    }

    class Solution {
        public String addBinary(String a, String b) {
            char[] first = a.toCharArray();
            char[] second = b.toCharArray();
            String result = "";
            int indexA = first.length - 1;
            int indexB = second.length - 1;
            int carryDigit = 0;

            while (indexA >= 0 || indexB >= 0 || carryDigit == 1) {
                int firstDigit = 0;
                int secondDigit = 0;
                if (indexA >= 0 && first[indexA] == '1') {
                    firstDigit = 1;
                }
                if (indexB >= 0 && second[indexB] == '1') {
                    secondDigit = 1;
                }
                int sum = firstDigit + secondDigit + carryDigit;
                if (sum >= 2) {
                    sum = sum % 2;
                    carryDigit = 1;
                } else {
                    carryDigit = 0;
                }

                result = sum + result;
                indexA--;
                indexB--;
            }
            return result;
        }
    }
}
