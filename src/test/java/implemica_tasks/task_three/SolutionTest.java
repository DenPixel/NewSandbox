package implemica_tasks.task_three;

import implemica_tasks.MyMath;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void factorialOneHundred(){
        Solution solution = new Solution();
        BigInteger result = MyMath.factorial(100);
        assertEquals(
                "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000",
                result.toString()
        );
    }

    @Test
    public void sumOfDigitsInNumberOneHundredFactorial(){
        Solution solution = new Solution();
        int result = solution.sumOfDigitsInNumber(
                "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"
        );
        assertEquals(648, result);
    }

}