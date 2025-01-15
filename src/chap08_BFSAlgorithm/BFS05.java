package chap08_BFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-13]
 * 문제 유형: [BFS 활용]
 * O표기법: [	O(N * M)]
 * 문제 이름: [백준 바이러스]
 * url : https://www.acmicpc.net/problem/2606
 */
import java.util.*;

public class BFS05 {
    static int n,m, count;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for (int computer : graph.get(cur)) {
                if (!visited[computer]) {
                    visited[computer] = true;
                    queue.offer(computer);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        count = 0;
        n = kb.nextInt();
        m = kb.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];


        for (int i = 0; i < m; i++) {
            int index = kb.nextInt();
            int value = kb.nextInt();

            graph.get(index).add(value);
            graph.get(value).add(index);
        }

        int result = bfs(1);
        System.out.println(result);


    }





}

