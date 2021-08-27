package solution;

/**
 * @id 258
 * @author dongjin
 * @date 2020/11/18 12:36
 */
public class AddDigits258 {

    public int addDigits(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if(sum > 9) {
            return addDigits(sum);
        } else {
            return sum;
        }
    }

    /**
     * f(x*10 + y) = f(x*9 + x + y) = f(x + y)
     * @param num
     * @return
     */
    public int addDigitsLeetcode(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        AddDigits258 temple = new AddDigits258();
        System.out.println(temple.addDigits(38));
    }
}
