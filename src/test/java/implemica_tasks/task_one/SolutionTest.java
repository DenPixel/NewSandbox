package implemica_tasks.task_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void oneBracket(){
        Solution solution = new Solution();
        int variation = solution.countVariationsOfCorrectBrackets(1);
        assertEquals(1, variation);
    }

    @Test
    public void twoBrackets(){
        Solution solution = new Solution();
        int variation = solution.countVariationsOfCorrectBrackets(2);
        assertEquals(2, variation);
    }

    @Test
    public void threeBrackets(){
        Solution solution = new Solution();
        int variation = solution.countVariationsOfCorrectBrackets(3);
        assertEquals(5, variation);
    }
}