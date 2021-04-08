package leetcode.easy;

import java.util.Arrays;

public class Solution {
    /*
    Given an array of integers nums and an integer target,
    return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution,
    and you may not use the same element twice.
    You can return the answer in any order.
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int k = i+1; k < nums.length - 1; i++){
                if(nums[i] + nums[k] == target){
                    return new int[]{i, k};
                }
            }
        }
        return new int[0];
    }

    /*
    Given a signed 32-bit integer x, return x with its digits reversed.
    If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1],
    then return 0.
     */
    public int reverse(int x) {
        long reverse = 0;

        while(x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return reverse >= Integer.MAX_VALUE || reverse <= Integer.MIN_VALUE ? 0 : (int)reverse;
    }


    /*
    Given an integer x, return true if x is palindrome integer.
    An integer is a palindrome when it reads the same backward as forward.
    For example, 121 is palindrome while 123 is not.
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String s = String.valueOf(x);
        StringBuilder rev = new StringBuilder(s).reverse();

        if (s.contentEquals(rev)) return true;

        return false;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    For example, 2 is written as II in Roman numeral, just two one's added together.
    12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     */
    public int romanToInt(String s) {
        int res = 0;
        int length = s.length();
        int[] ints = Arrays.stream(s.split(""))
                .mapToInt(c -> RomanNumbers.valueOf(c).getArab())
                .toArray();

        for (int i = 0; i < length - 1; i++) {
            int el = ints[i];
            res = (el < ints[i+1]) ? res - el : res + el;
        }

        res += ints[length - 1];

        return res;
    }

    enum RomanNumbers {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);
        private int arab;

        RomanNumbers(int arab) {
            this.arab = arab;
        }

        public int getArab() {
            return arab;
        }
    }
}
