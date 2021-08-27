package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @id 290
 * @author dongjin
 * @date 2020/11/18 14:16
 */
public class WordPattern290 {

    /**
     * 哈希表
     * 时间复杂度：
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] sList = s.split(" ");
        if (pattern.length() != sList.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!sList[i].equals(map.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                if(!map.containsValue(sList[i])) { // 需要遍历Hashmap
                    map.put(pattern.charAt(i), sList[i]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 增加一个HashSet
     * 空间换时间
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPatternLeetcode(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] sList = s.split(" ");
        if (pattern.length() != sList.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!sList[i].equals(map.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                if(set.add(sList[i])) {
                    map.put(pattern.charAt(i), sList[i]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern290 temple = new WordPattern290();
        System.out.println(temple.wordPattern("abba", "dog cat cat dog"));
    }
}
