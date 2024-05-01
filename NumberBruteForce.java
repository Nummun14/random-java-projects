public class NumberBruteForce {
    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    for (int u = 0; u <= 9; u++) {
                        System.out.println("" + i + j + k + u);
                    }
                }
            }
        }
    }
}
