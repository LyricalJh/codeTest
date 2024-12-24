package chap05_Prim;
import java.util.*;

class Edge implements Comparable<Edge> {
    int vertex;
    int cost;

    public Edge(int v, int c) {
        this.vertex = v;
        this.cost = c;
    }

    @Override
    public int compareTo(Edge o) {
        return cost - o.cost;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "vertex=" + vertex +
                ", cost=" + cost +
                '}';
    }
}

public class Prim01 {
    static ArrayList<ArrayList<Edge>> graph;
    static boolean[] visited;
    static int n,m, total;

    public void prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int vertex = edge.vertex;
            int cost = edge.cost;

            if (visited[vertex]) continue;
            visited[vertex] = true;
            total += cost;

            for (Edge e : graph.get(vertex)) {
                if (!visited[e.vertex]) {
                    pq.offer(e);
                }
            }
        }

    }

    public static void main(String[] args) {
        Prim01 T = new Prim01();
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        m = stdin.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        total = 0;

        for (int i = 0; i < m; i++) {
            int sp = stdin.nextInt();
            int ep = stdin.nextInt();
            int cost = stdin.nextInt();
            graph.get(sp).add(new Edge(ep, cost));
            graph.get(ep).add(new Edge(sp, cost));
        }

        T.prim(1);
        System.out.println(total);
    }
}
