package chap08_BFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-20]
 * 문제 유형: [BFS]
 * 문제 이름: [백준: 키 순서]
 * url : https://www.acmicpc.net/problem/2458
 */
import java.util.*;

public class BFS12 {

    static List<Integer>[] small_graph;
    static List<Integer>[] lager_graph;

    static int n, m, count = 0;

    public int bfs(int start, List<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(start);
        visited[start] = true;
        int cnt = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            cnt++;

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }

        }
        return cnt;
    }


    public static void main(String[] args) {
        BFS12 T = new BFS12();
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        m = stdin.nextInt();

        small_graph = new ArrayList[n + 1];
        lager_graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            small_graph[i] = new ArrayList<>();
            lager_graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = stdin.nextInt();
            int b = stdin.nextInt();

            small_graph[a].add(b);
            lager_graph[b].add(a);
        }

        for (int i = 1; i <=n; i++) {
            int smallerCount = T.bfs(i, small_graph) - 1;
            int largerCount = T.bfs(i, lager_graph) - 1;

            if (smallerCount + largerCount == n - 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
