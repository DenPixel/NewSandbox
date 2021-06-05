package implemica_tasks.task_one;

import implemica_tasks.MyMath;

public class Solution {

    /**
     * @param countBrackets the number of pairs of brackets.
     * @return Count of variations of correct brackets. Calculated by the formula (2n)!/n!(n+1)!
     */
    public int countVariationsOfCorrectBrackets(int countBrackets){
        return MyMath.factorial(2 * countBrackets)
                .divide(
                        MyMath.factorial(countBrackets).multiply(MyMath.factorial(countBrackets + 1))
                ).intValue();
        // calculated by the formula (2n)!/n!(n+1)!
    }
}
