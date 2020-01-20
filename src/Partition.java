import java.util.Scanner;

public class Partition
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        int e = s.nextInt();

        for (int ex=0; ex < e; ex++) {
            int count = s.nextInt();
            int m = s.nextInt();
            int n = s.nextInt();

            // Get maximum depth of the tree
            int l = (int)(Math.log(n) / Math.log(m)) + 1;
            int[] iter = new int[l];
            iter[0] = 1;

            int[] ir = new int[n + 1];
            ir[0] = 1;

            // All possible m-ary power terms (one is always an element)
            for (int i = 1; i < l; i++) {
                iter[i] = m * iter[i - 1];
            }

            // Iterate through the depth of the tree
            for (int i = 0; i < l; i++){
                for (int j = iter[i]; j <= n; j++){
                    ir[j] += ir[j - iter[i]];
                }
            }

            System.out.println(count + " " + ir[n]);
        }
    }
}
