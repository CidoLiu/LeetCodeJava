package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @id 118
 * @author dongjin
 * @date 2020/10/26 15:21
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return ans;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        for (int i = 1; i < numRows; i++) {
            List<Integer> now = new ArrayList<>();
            now.add(1);
            for (int j = 0; j < temp.size() - 1; j++) {
                now.add(temp.get(j) + temp.get(j + 1));
            }
            now.add(1);
            ans.add(now);
            temp = now;
        }
        return ans;
    }

    public static void main(String[] args) {
        PascalsTriangle temple = new PascalsTriangle();
        System.out.println(temple.generate(5));
    }
}
