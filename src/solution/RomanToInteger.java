package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongjin
 * @date 2020/10/13 14:12
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int answer = 0;
        for (int i = 0;i < s.length(); ++i) {
            if (i+1 < s.length() && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i+1))) {
                answer += romanMap.get(s.charAt(i+1)) - romanMap.get(s.charAt(i));
                ++i;
            }else{
                answer += romanMap.get(s.charAt(i));
            }
//            System.out.println(answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        RomanToInteger temple = new RomanToInteger();
        System.out.println(temple.romanToInt("MCMXCIV"));
    }


}
