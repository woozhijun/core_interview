/**
 * @Author: wuzhijun
 * @Date: 2020/10/18 23:16
 */
public class ClimbStairs {
    public static int fromType(int n) {
        int step1 = 1;
        int step2 = 2;
        int temp = 0;
        if (n <= 2) {
            return n;
        } else {
            for (int i = 2; i < n; i++) {
                temp = step1 + step2;
                step1 = step2;
                step2 = temp;
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i ++) {
            System.out.println(fromType(i));
        }
    }
}