package implemica_tasks.task_three;

import implemica_tasks.MyMath;

import java.math.BigInteger;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        BigInteger factorial = MyMath.factorial(100);
        int sum = solution.sumOfDigitsInNumber(factorial);

        System.out.println("100! = " + factorial.toString());
        System.out.println("Sum of the digits in the number 100! =  " + sum);
    }
}
