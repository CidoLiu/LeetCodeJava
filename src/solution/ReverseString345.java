package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @id 345
 * @author dongjin
 * @date 2020/11/18 15:46
 */
public class ReverseString345 {

    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                queue.offer(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                sb.append(stack.pop());
            } else {
                sb.append(queue.poll());
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ReverseString345 temple = new ReverseString345();
        System.out.println(temple.reverseVowels("aA"));
    }
}
