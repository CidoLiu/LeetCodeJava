package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongjin
 * @date 2020/10/13 20:48
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        Map<Integer, String> numMap = new HashMap<Integer, String>();
        numMap.put(1, "I");
        numMap.put(4, "IV");
        numMap.put(5, "V");
        numMap.put(9, "IX");
        numMap.put(10, "X");
        numMap.put(40, "XL");
        numMap.put(50, "L");
        numMap.put(90, "XC");
        numMap.put(100, "C");
        numMap.put(400, "CD");
        numMap.put(500, "D");
        numMap.put(900, "CM");
        numMap.put(1000, "M");
        int[] numArray = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        int index = numArray.length - 1;
//        String answer = "";
        StringBuilder answer = new StringBuilder();
        /*
        使用StringBuilder的性能更好。
        String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象是不可更改的，
        但后两者的对象是变量，是可以更改的。
         */
        while (num > 0) {
//            System.out.println(num);
//            System.out.println(answer);
            if(num >= numArray[index]){
//                answer = answer.concat(numMap.get(numArray[index]));
                answer.append(numMap.get(numArray[index]));
                num -= numArray[index];
//                index = numArray.length - 1; // 没有必要重置指针
            }else{
                --index;
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman temple = new IntegerToRoman();
        System.out.println(temple.intToRoman(800));
    }


}
