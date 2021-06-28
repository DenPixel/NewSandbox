package akvelon_task_two;

import java.util.ArrayDeque;
import java.util.Map;

public class BalanceVerificator {
    private final static Map<Character, Character> BRACKETS = Map.of(
            '[', ']',
            '{', '}',
            '(', ')'
    );

    /**
     * Checks if the line of brackets is balanced. If the line of brackets is balanced return -1
     * and return a number of not balanced brackets in the line.
     *
     * @param stringWithBrackets The string that must only have brackets: [, ], {, }, (, )
     * @return -1 if the line of brackets is balanced
     * and return a number of not balanced brackets in the line.
     * @throws IllegalArgumentException if the character is not [, ], {, }, (, )
     */
    public int verify(String stringWithBrackets) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char currentChar : stringWithBrackets.toCharArray()) {
            boolean containsKey = BRACKETS.containsKey(currentChar);
            boolean containsValue = BRACKETS.containsValue(currentChar);

            if (!containsKey && !containsValue)
                throw new IllegalArgumentException("The string must have only characters: [, ], {, }, (, )");

            if (containsKey) {
                stack.addLast(currentChar);
            } else {
                if (stack.isEmpty()) return 1;
                char lastOpenBracket = stack.peekLast();
                char pairForLastOpenBracket = BRACKETS.get(lastOpenBracket);

                if (currentChar != pairForLastOpenBracket) return stack.size();

                stack.pollLast();
            }
        }

        return stack.isEmpty() ? -1 : stack.size();
    }
}
