package chap04_DijkstraAlgorithm;
import java.util.*;

class Edge implements Comparable<Edge> {
    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
       return this.cost - o.cost;
    }
}

public class Dijkstra01 {

    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public void sol(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentVertex = current.vex;
            int currentCost = current.cost;
            if (currentCost > dis[currentVertex]) continue;
            for (Edge neighbor : graph.get(currentVertex)) {
                if (dis[neighbor.vex] > neighbor.cost + currentCost) {
                    dis[neighbor.vex] = neighbor.cost + currentCost;
                    pq.offer(new Edge(neighbor.vex, currentCost + neighbor.cost));
                }
            }
        }
    }

    public static void main(String[] args) {

        Dijkstra01 T = new Dijkstra01();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        dis = new int[n + 1];
        graph = new ArrayList<ArrayList<Edge>>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int index = sc.nextInt();
            int vertex = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(index).add(new Edge(vertex, cost));
        }
        T.sol(1);

        for (int i = 2 ; i <=n; i++) {
            if (dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }

    }
}
