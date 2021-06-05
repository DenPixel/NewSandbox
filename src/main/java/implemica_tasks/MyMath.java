package implemica_tasks;

import java.math.BigInteger;

public class MyMath {
    public static BigInteger factorial(int n){
        if (n < 0) throw new IllegalArgumentException();
        if (n <= 1) return BigInteger.ONE;

        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
