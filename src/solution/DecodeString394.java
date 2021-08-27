package solution;

import java.util.Stack;

/**
 * @id 394
 * @author dongjin
 * @date 2020/11/19 13:01
 */
public class DecodeString394 {

    /**
     * 看起来很简单的一道题，写了快一个小时了，一直不对，哭了
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        char temp;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '[') {
                stringStack.push("[");
            } else if (s.charAt(i) == ']') {
                int num = intStack.pop();
                stringStack.push(repeatString(sb.toString(),num));
                String stringStackPop = stringStack.pop();
                sb = new StringBuilder();
                while (!stringStackPop.equals("[")) {
                    sb.insert(0, stringStackPop);
                    stringStackPop = stringStack.pop();
                }
                if (stringStack.isEmpty()) {
                    ans.append(sb.toString());
                } else {
                    stringStack.push(sb.toString());
                }
            } else if (Character.isDigit(s.charAt(i))) {
                if (!"".equals(sb.toString())) {
                    stringStack.push(sb.toString());
                }
                intStack.push((int)s.charAt(i) - '0');
            } else {
                if (stringStack.isEmpty()) {
                    ans.append(s.charAt(i));
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }
        return ans.toString();
    }

    private String repeatString(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String decodeStringLeetcode(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> intStack = new Stack<Integer>();
        Stack<StringBuilder> stringStack = new Stack<StringBuilder>();
        int num = 0;
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (Character.isAlphabetic(c)) {
                ans.append(c);
            } else if (c == '[') {
                stringStack.add(ans);
                intStack.push(num);
                ans = new StringBuilder();
                num = 0;
            } else {
                StringBuilder ansTemp = stringStack.pop();
                int numTemp = intStack.pop();
                for (int i = 0; i < numTemp; ++i) {
                    ansTemp.append(ans);
                }
                ans = ansTemp;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        DecodeString394 temple = new DecodeString394();
        System.out.println(temple.decodeStringLeetcode("3[a2[cb]]"));
    }
}
