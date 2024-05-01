public class Square {
    public static boolean isSquare(int number) {
        double squareRoot = Math.sqrt(number);
        return squareRoot == Math.floor(squareRoot);
    }

    public static void main(String[] args) {
        System.out.println(isSquare(25));
    }
}