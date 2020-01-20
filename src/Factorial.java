import java.util.Scanner;

public class Factorial
{
    static final int DIGITS = 1000;

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        if (n < 1 || n > 10000000)
            return;

        long t = cf(n, 2) - cf(n, 5);

        if (t >= 2505) {
            t = (t - 5) % 2500 + 5;
        }

        long res = fact(n) * (int) Math.pow(2, t) % DIGITS;

        String ress = Long.toString(res);
        if (n > 7) {
            ress = String.format("%03d", res);
        }

        System.out.println(ress);
    }

    static long cf(long e, long n) {
        return (e == 0) ? 0 : e / n + cf(e / n, n);
    }

    static long fact(long n)
    {
        return (((n == 0) ? 1 : fact(n / 2)) * od(n)) % DIGITS;
    }

    static long od(long n) {
        return (n == 0) ? 1 : od(n / 5) * fp(n) % DIGITS;
    }

    static long fp(long n)
    {
        n %= DIGITS;
        long  p = 1;
        for (int i = 1; i < n + 1; i++) {
            if (i %5 != 0 && i % 2 != 0) {
                p = i * p % DIGITS;
            }
        }
        return p;
    }
}
