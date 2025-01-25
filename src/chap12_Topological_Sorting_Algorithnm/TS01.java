package chap12_Topological_Sorting_Algorithnm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-25]
 * 문제 유형: [위상정렬 Topological_Sorting]
 * LEVEL: 골드 3
 * 문제 이름: [백준: 줄세우기]
 * https://www.acmicpc.net/problem/2252
 * 문제 풀이
 * 풀이의 핵심은 진입 차수가 0 인것 부터 시작해서
 * 해당 그래프 간선을 제거 하면서 진입차수가 0인것들을 순서대로 넣어주는 정렬 알고리즘이다.
 */
import java.util.*;
public class TS01 {
    static int n, m;
    static int[] indegree;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        TS01 T = new TS01();
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        m = stdin.nextInt();

        indegree = new int[n + 1];
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int vertex = stdin.nextInt();
            int edge = stdin.nextInt();
            graph.get(vertex).add(edge);
            indegree[edge]++;
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for (int next : graph.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }

        System.out.println(sb.toString());

    }
}
