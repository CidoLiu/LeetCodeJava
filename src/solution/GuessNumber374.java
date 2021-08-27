package solution;

/**
 * @id 374
 * @author dongjin
 * @date 2020/11/19 12:06
 */
public class GuessNumber374 {

    /**
     * 二分搜索的应用
     * 时间复杂度：O(logn)
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int low = 1;
        int upper = n;
        int mid = low + (upper - low) / 2;
        int guessAnswer = guess(mid);
        while (guessAnswer != 0) {
            mid = low + (upper - low) / 2;
            guessAnswer = guess(mid);
            if (guessAnswer == 1) {
                low = mid + 1;
            } else if (guessAnswer == -1) {
                upper = mid - 1;
            } else {
                return mid;
            }
        }
        return mid;
    }

    int guess(int num) {
        return -1;
    }

    public static void main(String[] args) {
        GuessNumber374 temple = new GuessNumber374();
        System.out.println();
    }
}
