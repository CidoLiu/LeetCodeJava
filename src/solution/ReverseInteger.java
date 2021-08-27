package solution;


public class ReverseInteger {

    public int reverse(int x) {
        /*
        * 假设程序的运行环境为32位有符号整数，需要考虑溢出问题
        * */
//        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){ // 可能在计算过程中溢出、结果溢出
//            return 0;
//        }
        long answer = 0; // 这个long可能不符合题目要求，因为题目给的环境不支持long，但是在Java中是没问题了，可以AC
        while (x != 0) {
//            System.out.println(answer);
            answer = answer * 10 + x % 10;
            x /= 10;
        }
        int int_answer = (int)answer;
        return int_answer==answer ? int_answer:0;
    }

    public int reverseByLeetcode(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 2^31-1=2147483647,-2^31=-2147483648
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args){
        ReverseInteger temple = new ReverseInteger();
        System.out.println(temple.reverse(-345));
//        double a = Math.pow(2, 31);
//        System.out.println(-567%10);
    }

}
