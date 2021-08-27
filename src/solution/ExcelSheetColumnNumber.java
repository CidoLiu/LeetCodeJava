package solution;

/**
 * @id 171
 * @author dongjin
 * @date 2020/11/8 13:24
 */
public class ExcelSheetColumnNumber {

    /*
    * 26进制转10进制
    * 注意：这里的26进制并不是严格的26进制，需要-1后，才是正常的26进制
    * 时间复杂度：O(n)
    * 空间复杂度：O(1)
    * */
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            ans += (int)(s.charAt(i) -'A' + 1) * Math.pow(26, j);
        }
        return ans;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber temple = new ExcelSheetColumnNumber();
        System.out.println(temple.titleToNumber("AB"));
    }
}
