package leetcode.easy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private static Solution solution;

    @BeforeAll
    public static void beforeClass() {
        solution = new Solution();
    }

    @Test
    public void findTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = new int[]{0, 1};

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }

    @Test
    public void doNotFindTwoSum() {
        int[] nums = {5, 5};
        int target = 7;
        int[] expected = new int[0];

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }

    @Test
    public void reverseZero() {
        assertEquals(0, solution.reverse(0));
    }

    @Test
    public void reversePositiveNumber() {
        assertEquals(321, solution.reverse(123));
    }

    @Test
    public void reverseNegativeNumber() {
        assertEquals(-321, solution.reverse(-123));
    }

    @Test
    public void reverseNumberEndWithZero() {
        assertEquals(21, solution.reverse(120));
    }

    @Test
    public void reverseIntegerMaxValue() {
        assertEquals(0, solution.reverse(Integer.MAX_VALUE));
    }

    @Test
    public void reverseIntegerMinValue() {
        assertEquals(0, solution.reverse(Integer.MIN_VALUE));
    }

    @Test
    public void negativeNumberIsNotPalindrome() {
        assertFalse(solution.isPalindrome(-123));
    }

    @Test
    public void numberIsPalindrome() {
        assertTrue(solution.isPalindrome(123321));
    }

    @Test
    public void numberIsNotPalindrome() {
        assertFalse(solution.isPalindrome(123));
    }

    @Test
    public void roman() {
        assertEquals(1994, solution.romanToArab("MCMXCIV"));
    }
}