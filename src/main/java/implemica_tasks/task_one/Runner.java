package implemica_tasks.task_one;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of pairs of brackets: ");
        int n = scanner.nextInt();
        int variation = solution.countVariationsOfCorrectBrackets(n);
        System.out.println("Count of variations of correct brackets: " + variation);
    }
}
