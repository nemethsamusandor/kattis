import java.util.Scanner;

public class A1Paper
{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();

        int[] numOfSheets = new int[t-1];

        for (int i = 0; i < t-1; i++) {
            numOfSheets[i] = s.nextInt();
        }

        double possible = 0;
        for (int i = 0; i < numOfSheets.length; i++) {
            possible += numOfSheets[i] * (0.5 / Math.pow(2, i));
        }

        if (possible < 1) {
            System.out.println("impossible");
        }
        else if (possible > 1) {

        }
        else {
            // short x long side
            final double[] A2S_SIZE = new double[]{Math.pow(2, -1.25), Math.pow(2, -0.75)};



            double len = Math.pow(2, -0.75);

            System.out.printf("%f", len);
        }
    }
}
