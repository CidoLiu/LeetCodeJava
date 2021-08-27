package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @id 205
 * @author dongjin
 * @date 2020/11/8 16:53
 */
public class IsomorphicStrings {

    /*
    * 时间复杂度：O(n)
    * */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                ans.append(map.get(s.charAt(i)));
            } else if(map.containsValue(t.charAt(i))){
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
                ans.append(t.charAt(i));
            }
        }
        System.out.println(ans.toString());
        return ans.toString().equals(t);
    }

    public boolean isIsomorphicFind(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        IsomorphicStrings temple = new IsomorphicStrings();
        System.out.println(temple.isIsomorphicFind("abb", "cdd"));
    }
}
