package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @id 118
 * @author dongjin
 * @date 2020/10/26 15:21
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> now = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        if (rowIndex == 0) {
            return pre;
        }
        for (int i = 0; i < rowIndex; i++) {
//            now.clear();
            now = new ArrayList<>();
            now.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                now.add(pre.get(j) + pre.get(j + 1));
            }
            now.add(1);
            pre = now;
        }
        return now;
    }

    /**
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     */
    public List<Integer> getRowByMath(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int)cur);
            cur = cur * (rowIndex - i) / (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangleII temple = new PascalsTriangleII();
        System.out.println(temple.getRow(1));
    }
}
