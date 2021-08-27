package solution;

/**
 * @author dongjin
 * @date 2020/10/22 15:30
 */
public class CountAndSay {

    /*
    * 递归求解
    * 使用String来操作字符串，效率会大打折扣，推荐使用StringBuilder
    * 使用String来操作字符串，运行时间：27ms
    * 使用StringBuilder来操作字符串，运行时间：4ms
    * 时间复杂度：O()?
    * */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            return say(countAndSay(n - 1));
        }
    }

    public String say(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 1;
        Character temp = s.charAt(0);
        for (int i = 1; i < s.length(); ++i) {
            if (temp == s.charAt(i)) {
                count++;
            } else {
                ans.append(count);
                ans.append(temp);
                count = 1;
                temp = s.charAt(i);
            }
        }
        if (count != 0) {
            ans.append(count);
            ans.append(temp);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        CountAndSay temple = new CountAndSay();
        System.out.println(temple.countAndSay(20));
    }
}
