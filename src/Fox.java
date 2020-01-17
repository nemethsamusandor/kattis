import java.util.Scanner;

public class Fox{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in).useDelimiter("[\\r\\n;]");
        int t = s.nextInt();
        for (int i = 0; i < t; i++){
            String p = s.next();
            String n = s.next();
            while (!n.equals("what does the fox say?")){
                String a = n.replaceAll(".* goes ", "");
                p = p.replaceAll("\\b"+a+"\\b", "");
                n = s.next();
            }
            p = p.replaceAll("\\s{2,}", " "). trim();
            System.out.println(p);
        }
    }
}
