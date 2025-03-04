package chap13_BruteForceAlgorithm;

import java.util.Scanner;

/**
 * 작성자: [소중한]
 * 작성일: [2025-01-25]
 * 문제 유형: [백 트래킹]
 * LEVEL: 실버 3
 * 문제 이름: [백준: N과 M (1)]
 *https://www.acmicpc.net/problem/15649
 * 문제 풀이
 * 재귀함수를 활용하여 백트래킹
 * 특정 노드 (탐색할 곳) 찾는 해가에 적합하지 않다면 부모 노드로 돌아가 다른 노드 탐색하는 알고리즘
 */
public class NM_1 {

    static int n, m;
    static int[] result;
    static boolean[] visited;

    static public void DFS(int depth) {
        // 문제의 조건을 찾았다면
        if (depth == m) {
            for (int val : result) System.out.print(val + " ");
            System.out.println();
            return;
        }

        // 아직 조건에 도달하지 못했다면 탐색
        for (int i = 1 ; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                // 다른 노드로 이동
                DFS(depth + 1);
                visited[i] = false;
            }

        }
    }
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        n = stdin.nextInt();
        m = stdin.nextInt();

        result = new int[m];
        visited = new boolean[n + 1];
        DFS(0);
    }
}
