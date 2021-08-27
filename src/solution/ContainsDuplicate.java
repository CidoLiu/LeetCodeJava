package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @id 217
 * @author dongjin
 * @date 2020/11/9 9:26
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate temple = new ContainsDuplicate();
        System.out.println();
    }
}
