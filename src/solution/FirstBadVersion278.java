package solution;

/**
 * @id 278
 * @author dongjin
 * @date 2020/11/18 12:55
 */
public class FirstBadVersion278 {

    /**
     * 仿二分搜索
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int n) {
        return false;
    }


    public static void main(String[] args) {
        FirstBadVersion278 temple = new FirstBadVersion278();
        System.out.println();
    }
}
