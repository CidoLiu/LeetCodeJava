package solution;

import java.util.Stack;

/**
 * @id 168
 * @author dongjin
 * @date 2020/11/7 20:19
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            n--; // 这里并不是标准的26进制，标准的26进制是0开始的，这里是1开始的
            stack.push(n % 26);
            n /= 26;
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.empty()) {
//            System.out.println(stack.peek());
            ans.append((char)(stack.pop() + 'A'));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle temple = new ExcelSheetColumnTitle();
        System.out.println(temple.convertToTitle(26));
    }
}
