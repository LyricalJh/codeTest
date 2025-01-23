package chap08_BFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-13]
 * 문제 유형: [BFS, DFS 활용]
 * LEVEL : 실버 2
 * 문제 이름: [백준 촌수계산]
 * url : https://www.acmicpc.net/problem/2644
 * BFS 로 하면 정말 간단하게 풀리는 문제인데 DFS 알고리즘으로는 어떻게 해결할까?
 */

import java.util.*;
public class BFS14 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int n, start, target, k, answer = -1;
    static boolean[] visited;

    public int BFS(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int curPosition = cur[0];
            int distance = cur[1];

            if (curPosition == target) return distance;

            for (int neighbor : graph.get(curPosition)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, distance + 1});
                }

            }
        }
        return -1;
    }

    public void DFS(int current, int distance) {
        if (current == target) {
            answer = distance;
            return;
        }
        visited[current] = true;
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                DFS(neighbor, distance + 1);
            }
        }
    }

    public static void main(String[] args) {
        BFS14 T = new BFS14();
        Scanner stdin = new Scanner(System.in);

        // 총 인구수
        n = stdin.nextInt();
        for (int i = 1; i <= n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        start = stdin.nextInt();
        target = stdin.nextInt();
        // 촌수 관계데이터 총 건수
        k = stdin.nextInt();
        for (int i = 0; i < k; i++) {
            int vertex = stdin.nextInt();
            int edge = stdin.nextInt();
            // 서로 관계가 있음.
            graph.get(vertex).add(edge);
            graph.get(edge).add(vertex);
        }
        //System.out.println(T.BFS(start, target));
        T.DFS(start, 0);
        System.out.println(answer);
    }
}
