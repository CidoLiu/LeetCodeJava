package solution;

/**
 * @author dongjin
 * @date 2020/10/23 11:40
 */
public class AddBinary {

    /*
    * 递归求解
    * 每次递归，得到加法结果，和进位结果两个字符串
    * 递归结束条件：直到String b全为0，则结束递归，返回String a
    * */
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int firstOne = -1;

        for (int i = 0; i < lenB; i++){
            if (b.charAt(i) == '1') {
                firstOne = i;
                break;
            }
        }
        if (firstOne == -1) {
            return a;
        } else {
            b = b.substring(firstOne); // 删除进位串前的0，避免最终结果前有0
            lenB = b.length();
        }

        int i = lenA - 1;
        int j = lenB - 1;
        StringBuilder ans = new StringBuilder();
        StringBuilder carry = new StringBuilder();
        carry.insert(0, '0');
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                ans.insert(0, '0');
                carry.insert(0, '1');
            } else if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                ans.insert(0, '0');
                carry.insert(0, '0');
            } else {
                ans.insert(0, '1');
                carry.insert(0, '0');
            }
            --i;
            --j;
        }
//        System.out.println(i);
//        System.out.println(j);
        if (i >= 0){ ans.insert(0, a.substring(0, i + 1)); }
        if (j >= 0){ ans.insert(0, b.substring(0, j + 1)); }
//        System.out.println(ans);
//        System.out.println(carry);
        return addBinary(ans.toString(), carry.toString());
    }

    /*
    * 模拟手算
    * 通过整除2和模2运算，得到当前位和进位位
    * 时间复杂度：O(max{|a|, |b|})
    * 空间复杂度：O(1)
    * */
    public String addBinaryLeetcodeByMod(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int carry = 0;
        int n = Math.max(lenA, lenB);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            carry += i < lenA ? (a.charAt(lenA - 1 - i) - '0') : 0; // 通过一个逗号表达式，解决了数据不对齐的问题
            carry += i < lenB ? (b.charAt(lenB - 1 - i) - '0') : 0;
            ans.append(carry % 2);
            carry /= 2;
        }
        if (carry == 1) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        AddBinary temple = new AddBinary();
        System.out.println(temple.addBinaryLeetcodeByMod("100110", "111111"));
    }
}
