import java.util.concurrent.TimeUnit;

/**
 * Brennan Duffy
 * 10/19/2022
 */
public class InfiniteSeries {


    public static void main(String[] args) throws InterruptedException {
        int n = 17;
        // when x = 1, 17 iterations seems to be as accurate as it gets.
        for (double x : new double[] {0.1, 1, 10, 100}) {
            check(x, n);
        }
        // as x grows larger, the estimate gets further and further off
        for (double x : new double[] {-0.1, -1, -10, -100}) {
            check(x, n);
        }
        // same story with the negative values, the further it gets from 0, the larger the disparity is
    }

    public static double myExp(double x, int n) {

        double num = 1;
        double denom = 1;
        double total = 1;

        for (int i = 1; i <= n; i++) {
            num *= x;
            denom *= i;
            total += num / denom;
        }

        return total;
    }

    public static double check(double x, int n) {
        double exp = myExp(x, n);
        System.out.printf("%12s  %s%n", "x:", x);
        System.out.printf("%12s  %s%n", "myExp(x):", exp);
        System.out.printf("%12s  %s%n", "Math.exp(x):", Math.exp(x));
        return exp;
    }
}
