import java.util.ArrayList;
import java.util.List;

public class GameWithWeirdRules {

    static int calculate(String[] ops) {
        List<Integer> scores = new ArrayList<>();
        for (String ops1 : ops) {
            switch (ops1) {
                case "c" -> scores.remove(scores.size() - 1);
                case "d" -> {
                    int d = scores.size() - 1;
                    d = scores.get(d);
                    d *= 2;
                    scores.add(d);
                }
                case "+" -> {
                    int plus = scores.size() - 1;
                    int plus1 = scores.get(plus);
                    plus1 += scores.get(plus - 1);
                    scores.add(plus1);
                }
                default -> {
                    int number = Integer.parseInt(ops1);
                    scores.add(number);
                }
            }
        }
        int sum = 0;
        for (Integer score : scores) {
            sum += score;
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] ops = {"5", "2", "c", "d", "+"};
        System.out.println(calculate(ops));
    }
}