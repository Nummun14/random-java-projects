public class SingleDigit {
    private static int getOneDigit(double number) {
        return (int) number % 10;
    }
    private static int getTenDigit(double number) {
        int thing = (int) number % 10;
        int bla = (int) number - thing;
        int stuff = bla / 10;
        return stuff % 10;
    }

    private static int getHundredDigit(double number) {
        int thing = (int) number % 100;
        int bla = (int) number - thing;
        int stuff = bla / 100;
        return stuff % 10;
    }

    private static int getThousandDigit(double number) {
        int thing = (int) number % 1000;
        int bla = (int) number - thing;
        int stuff = bla / 1000;
        return stuff % 10;
    }

    public static void main(String[] args) {
        System.out.println(getOneDigit(1234));
        System.out.println(getTenDigit(1234));
        System.out.println(getHundredDigit(1234));
        System.out.println(getThousandDigit(1234));
    }
}