package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author dongjin
 * @date 2020/10/22 13:00
 */
public class ValidParentheses {
    /*
    * 时间复杂度为O(n)
    * */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 ==1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (isLeftParenthesis(s.charAt(i))) {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.empty()){
                return false;
            }
            if (isMatched(stack.peek(), s.charAt(i))) {
                stack.pop();
            } else {
                return false;
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    /*
    * 检测是否为左括号，若是，则返回true
    * */
    public boolean isLeftParenthesis(Character c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }
    /*
    * 检测左右括号匹配，可以使用一个HashMap来匹配，而不是函数。
    * */
    public boolean isMatched(Character a, Character b) {
        if (a == '(' && b == ')') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }
        if (a == '{' && b == '}') {
            return true;
        }
        return false;
    }

    /*
    * 官方题解，使用HashMap来存储括号
    * 时间复杂度为O(N)
    * 空间复杂度为o(N+m)
    * */
    public boolean isValidLeetcode(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < n; ++i) {
//            System.out.println(s.charAt(i));
            if (pairs.containsKey(s.charAt(i))) {
                if (stack.empty() || pairs.get(s.charAt(i)) != stack.peek()) {
                    return false;
                }
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses temple = new ValidParentheses();
        System.out.println(temple.isValidLeetcode("{[]}"));
    }
}
