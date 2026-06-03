import java.util.*;

public class JobInterviewSolutions {
    public static int solution1(int[] A) {
        Arrays.sort(A);
        int answer = 1;
        for (int i : A) {
            if (i == answer)
                answer++;
            else if (i > answer)
                return answer;
        }
        return answer;
    }

    public static String solution2(String date) {
        ArrayList<String> possibleMonths = new ArrayList<>(List.of("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));
        ArrayList<String> possibleDays = new ArrayList<>(List.of(
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31"
        ));

        String[] dateParts = date.split("-");
        String monthPattern = dateParts[0];
        String dayPattern = dateParts[1];

        possibleMonths.removeIf(month ->
                (monthPattern.charAt(0) != '?' && month.charAt(0) != monthPattern.charAt(0)) ||
                        (monthPattern.charAt(1) != '?' && month.charAt(1) != monthPattern.charAt(1))
        );

        possibleDays.removeIf(day ->
                (dayPattern.charAt(0) != '?' && day.charAt(0) != dayPattern.charAt(0)) ||
                        (dayPattern.charAt(1) != '?' && day.charAt(1) != dayPattern.charAt(1))
        );

        String latestValidDate = getMaxDate(possibleMonths, possibleDays);

        return latestValidDate.isEmpty() ? "xx-xx" : latestValidDate;
    }

    private static String getMaxDate(ArrayList<String> possibleMonths, ArrayList<String> possibleDays) {
        String latestValidDate = "";

        for (String month : possibleMonths) {
            int maxDay = switch (Integer.parseInt(month)) {
                case 2 -> 28;
                case 4, 6, 9, 11 -> 30;
                default -> 31;
            };
            for (String day : possibleDays) {
                int dayInt = Integer.parseInt(day);
                if (dayInt <= maxDay) {
                    String candidate = month + "-" + day;
                    if (candidate.compareTo(latestValidDate) > 0) {
                        latestValidDate = candidate;
                    }
                }
            }
        }
        return latestValidDate;
    }

    public static int solution3(int[] client) {
        Integer[] boxedArray = Arrays.stream(client).boxed().toArray(Integer[]::new);
        LinkedList<Integer> clients = new LinkedList<>(Arrays.asList(boxedArray));
        int maxAmountOnShelf = 0;
        HashSet<Integer> shelf = new HashSet<>();
        int k = 1;
        while (!clients.isEmpty()) {
            for (int i = k; i < clients.element(); i++)
                shelf.add(i);

            shelf.remove(clients.element());
            clients.remove();
            k++;

            if (shelf.size() - 1 > maxAmountOnShelf)
                maxAmountOnShelf = shelf.size() - 1;
        }
        return maxAmountOnShelf;
    }

    public static int solution4(String S, String C) {
        String[] rows = S.split("\n");
        String[] columns = rows[0].split(",");
        ArrayList<String> columnList = new ArrayList<>(Arrays.asList(columns));
        int index = columnList.indexOf(C);

        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i < rows.length; i++) {
            String[] values = rows[i].split(",");
            int value = Integer.parseInt(values[index]);
            if (value > maxValue)
                maxValue = value;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(solution2("?1-31"));
        System.out.println(solution2("02-??"));
        System.out.println(solution2("??-4?"));
        System.out.println(solution2("?9-31"));
    }
}