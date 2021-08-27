package solution;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

    // 保存递归的中间结果，避免重复计算
    private ArrayList[] cache = new ArrayList[100];

    public List<String> generateParenthesis(int n) {
        return generate(n);
    }

    // 递归生成
    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generate(i)) {
                    for (String right : generate(n - i - 1)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public static void main(String[] args) {
        GenerateParentheses22 test = new GenerateParentheses22();
        System.out.println(test.generateParenthesis(3));
    }
}
