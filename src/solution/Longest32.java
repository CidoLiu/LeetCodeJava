package solution;

import java.util.Stack;

public class Longest32 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()) {
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            if (c == '(') {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 暴力解法，超时
     * 时间复杂度：O(n^3)
     */
    public int longestValidParentheses(String s) {
        int len = s.length();
        int possibleMax = len % 2 == 0 ? len : len - 1;
        if (possibleMax == 0) {
            return 0;
        }
        int maxLen = 0;
        for (int i = possibleMax; i > 0; i -= 2) {
            for (int j = 0; j + i <= len; j++) {
                if (s.charAt(j) == ')') {
                    continue;
                }
                if (isValid(s.substring(j, j + i))) {
//                    System.out.println(s.substring(j, j + i));
                    if (i > maxLen) {
                        maxLen = i;
                    }
                }
            }
        }
        return maxLen;
    }

    public int longestValidParenthesesStack(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Longest32 test = new Longest32();
        System.out.println(test.longestValidParenthesesStack(")()())"));
    }
}
