package chap04_DijkstraAlgorithm;
import java.util.*;


public class Dijkstra03 {
    static ArrayList<ArrayList<Edge>> graph;
    static int[] distance;
    static int n;

    public void sol(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentVertex = current.vex;
            int currentCost = current.cost;
            if (currentCost > distance[currentVertex]) continue;
            for (Edge neighbor : graph.get(currentVertex)) {
                if (distance[neighbor.vex] > currentCost + neighbor.cost) {
                    distance[neighbor.vex] = currentCost + neighbor.cost;
                    pq.offer(new Edge(neighbor.vex, neighbor.cost + currentCost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Dijkstra03 T = new Dijkstra03();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] vertex = {
                {3,6},
                {4,3},
                {3,2},
                {1,3},
                {1,2},
                {2,4},
                {5,2}
        };

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int[] info : vertex) {
            int start = info[0];
            int end = info[1];
            int cost = 1;
            graph.get(start).add(new Edge(end, cost));
            graph.get(end).add(new Edge(start, cost));
        }

        T.sol(1);
        int maxValue = Arrays.stream(distance).filter(d -> d!= Integer.MAX_VALUE).max().orElseThrow();
        System.out.println("최대값 : " + maxValue);
        int answer = (int) Arrays.stream(distance).filter(d -> d == maxValue)
                .count();

        System.out.println(answer);
    }
}
