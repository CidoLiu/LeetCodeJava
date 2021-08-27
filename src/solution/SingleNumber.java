package solution;

/**
 * @id 136
 * @author dongjin
 * @date 2020/11/7 13:59
 */
public class SingleNumber {

    /*
    * 瞿建大佬看一眼就给出了这个解法，实在是太大佬了。
    * */
    public int singleNumber(int[] nums) {
        Integer n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            n ^= nums[i];
        }
//        System.out.println(n);
        return n;
    }

    public static void main(String[] args) {
        SingleNumber temple = new SingleNumber();
        System.out.println(temple.singleNumber(new int[] {4,1,2,1,2}));
    }
}
