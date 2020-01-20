import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Repeat
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in).useDelimiter("[\\r\\n;]");

        List<String> a = Arrays.asList(s.next().split(" "));
        Set<String> b = new HashSet<>(a);

        if (b.size() < a.size()) {
            System.out.println("no");
        }
        else {
            System.out.println("yes");
        }
    }
}
