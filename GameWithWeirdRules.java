import java.util.ArrayList;
import java.util.List;

public class GameWithWeirdRules {

    static int calculate(String[] ops) {
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("c")) {
                scores.remove(scores.size() - 1);
            } else if (ops[i].equals("d")) {
                int d = scores.size() - 1;
                d = scores.get(d);
                d *= 2;
                scores.add(d);
            } else if (ops[i].equals("+")) {
                int plus = scores.size() - 1;
                int plus1 = scores.get(plus);
                plus1 += scores.get(plus - 1);
                scores.add(plus1);
            } else {
                int number = Integer.parseInt(ops[i]);
                scores.add(number);
            }
        }
        int sum = 0;
        for (int i = 0; i < scores.size(); i++) {
            sum += scores.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] ops = {"5", "2", "c", "d", "+"};
        System.out.println(calculate(ops));
    }
}