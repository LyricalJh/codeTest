package chap04_DijkstraAlgorithm;
import java.util.*;
import java.util.stream.IntStream;

class Node implements Comparable<Node> {
    int vertex;
    int cost;

    public Node (int vertex, int cost ) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "vertex=" + vertex +
                ", cost=" + cost +
                '}';
    }
}

public class Dijkstra02 {
    static ArrayList<ArrayList<Node>> graph;
    static int[] distance;
    static int n;

    public void sol(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            System.out.println("현재 노드 : " + current);
            int currentVertex = current.vertex;
            int currentCost = current.cost;
            if (currentCost > distance[currentVertex]) continue;
            for (Node neighbor : graph.get(currentVertex)) {
                if (distance[neighbor.vertex] > neighbor.cost + currentCost) {
                    distance[neighbor.vertex] = neighbor.cost + currentCost;
                    pq.offer(new Node(neighbor.vertex, neighbor.cost + currentCost));
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        Dijkstra02 T = new Dijkstra02();
        int[][] road = {
                {1, 2, 1},
                {2, 3, 3},
                {5, 2, 2},
                {1, 4, 2},
                {5, 3, 1},
                {5, 4, 2}
        };

        n = stdin.nextInt();
        graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int[] info : road) {
            int index = info[0];
            int vertex = info[1];
            int cost = info[2];
            graph.get(index).add(new Node(vertex, cost));
            graph.get(vertex).add(new Node(index, cost));
        }

        T.sol(1);

       int answer = (int) IntStream.of(distance)
               .filter(d -> d <=3)
               .count();

        System.out.println(answer);

    }
}
