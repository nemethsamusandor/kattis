import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Partition2
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        int c = s.nextInt();


        for (int i=0; i < c; i++) {
            int count = s.nextInt();
            int m, p;
            m = p = s.nextInt();
            int n = s.nextInt();

            while(n >= p) {
                p *= m;
            }

            Set<int[]> set = new HashSet<>(n);
            partition(set, n, m, p);
            System.out.println(count + " " + set.size());
        }
    }

    private static void partition(Set<int[]> set, int n, int m, int p) {
        if(n == 0 || p <= 1) {
            return;
        }

        int[] i = new int[]{n, p};

        if(n >= p) {
            partition(set, n-p, m, p);
        }

        partition(set, n, m, p/m);

        set.add(i);
    }
}
