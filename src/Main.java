import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Kattio io = new Kattio(System.in);

        int n = io.getInt();
        int m = io.getInt();

        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> d = new ArrayList<>();

        List<Edge> edges = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            int n1 = io.getInt(), n2 = io.getInt();
            n1--;
            n2--;

            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
            edges.add(new Edge(n1,n2));
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j < adj.get(i).size(); j++) {
                join(d, adj.get(i).get(j-1), adj.get(i).get(j));
            }
        }

        boolean odd = false;
        for(int i = 0; i < n; i++) {
            if(d.get(i) < 0) {
                for(int j : adj.get(i)) {
                    if(find(d,i) == find(d,j)) {
                        odd = true;
                    }
                }
            }
        }

        for(Edge edge : edges) {
            join(d,edge.getI1(),edge.getI2());
        }

        int components = 0;
        for(int i = 0; i < n; i++) {
            if(d.get(i) < 0) components++;
        }

        components--;
        if(!odd) components++;

        io.println(components);

        io.close();
    }

    private static int find(List<Integer> d, int a) {
        if (d.get(a) < 0)
        {
            return a;
        }

        return find(d, d.get(a));
    }

    private static void join(List<Integer> d, int a, int b) {
        a = find(d, a);
        b = find(d, b);
        if(a == b) return;

        int a1 = d.get(a);
        a1 += d.get(b);
        d.add(a, a1);
        d.add(b, a);
    }

    private static class Edge
    {
        private final Integer i1;
        private final Integer i2;

        Edge(Integer i1, Integer i2)
        {
            this.i1 = i1;
            this.i2 = i2;
        }

        Integer getI1()
        {
            return i1;
        }

        Integer getI2()
        {
            return i2;
        }
    }
}
