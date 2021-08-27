package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumber17 {

    HashMap<Integer, String> phoneMap = new HashMap<>();

    // 构建字典，回溯
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        phoneMap.put(2, "abc");
        phoneMap.put(3, "def");
        phoneMap.put(4, "ghi");
        phoneMap.put(5, "jkl");
        phoneMap.put(6, "mno");
        phoneMap.put(7, "pqrs");
        phoneMap.put(8, "tuv");
        phoneMap.put(9, "wxyz");
        traceBack(combinations, digits, 0, new StringBuilder());
        return combinations;
    }

    public void traceBack(List<String> combinations, String digits, int index, StringBuilder combination) {
        if (digits.length() == index) {
            combinations.add(combination.toString());
            return;
        }
        String str = phoneMap.get(Integer.parseInt(String.valueOf(digits.charAt(index))));
        for (int i = 0; i < str.length(); i++) {
            combination.append(str.charAt(i));
            traceBack(combinations, digits, index + 1, combination);
//            System.out.println(combination);
            combination.deleteCharAt(combination.length()-1);
        }
    }

    public static void main(String[] args) {
        PhoneNumber17 phoneNumber17 = new PhoneNumber17();
        System.out.println(phoneNumber17.letterCombinations("234"));
    }
}
