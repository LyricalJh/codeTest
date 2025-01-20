package chap03_DFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-20]
 * 문제 유형: [DFS]
 * 문제 이름: [백준: 바이러스]
 * url : https://www.acmicpc.net/problem/2606
 */

import java.util.*;

public class DFS03 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int n, m, answer = 0;

    public void DFS(int index) {
        visited[index] = true;
        for (int next : graph.get(index)) {
            if (!visited[next]) {
                answer++;
                DFS(next);
            }
        }
    }
    public static void main(String[] args) {
        DFS03 T = new DFS03();
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        m = stdin.nextInt();

        visited = new boolean[n + 1];
        // 초기화 N 개수 만큼의 컴퓨터 셋팅
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int index = stdin.nextInt();
            int value = stdin.nextInt();

            // 서로 연결되어있다.
            graph.get(index).add(value);
            graph.get(value).add(index);
        }

        T.DFS(1);

        System.out.println(answer);

    }
}
