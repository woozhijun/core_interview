import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: wuzhijun
 * @Date: 2020/10/19 00:40
 */
public class IntegerOperator {

    public List<Integer> getNumbers(List<Integer> randomNums) {

        return null;
    }

    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> randomNums = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            randomNums.add(r.nextInt(10) + 1);
        }
    }
}
