package implemica_tasks.task_three;

import java.math.BigInteger;

public class Solution {


    /**
     * @param number number in which to calculate the sum of digits.
     *               String type because number can be huge.
     * @return Sum of digits in the number
     */
    public int sumOfDigitsInNumber(String number){
        if (number.length() == 0) return 0; // If empty then return 0

        int result = 0;
        char[] chars = number.toCharArray(); // Take characters from the string with the number

        for (char digit : chars) { // Go through each character
            if (digit == '0') continue; // If character is '0' then go to the next
            if (!Character.isDigit(digit)) throw new IllegalArgumentException();
            // If character is not digit then trows the exception

            result += Character.getNumericValue(digit); // take digit from character and plus with the result
        }

        return result;
    }


    /**
     * @param number number in which to calculate the sum of digits.
     * @return Sum of digits in the number
     */
    public int sumOfDigitsInNumber(BigInteger number){
        if (number == null) return 0; // If empty then return 0
        return sumOfDigitsInNumber(number.toString());
    }
}
