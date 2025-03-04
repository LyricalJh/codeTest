package chap13_BruteForceAlgorithm;

import java.util.Scanner;

/**
 * 작성자: [소중한]
 * 작성일: [2025-01-25]
 * 문제 유형: [백 트래킹]
 * LEVEL: 실버 3
 * 문제 이름: [백준: N과 M (2)]
 * https://www.acmicpc.net/problem/15650
 * 문제 풀이
 * 재귀함수를 활용하여 백트래킹
 * 특정 노드 (탐색할 곳) 찾는 해가에 적합하지 않다면 부모 노드로 돌아가 다른 노드 탐색하는 알고리즘
 */
public class NM_2 {
    static int n, m;
    static int[] result;
    static boolean[] visited;

    static public void DFS(int depth, int at) {
        // 원하는 조건에 도달하면 출력
        if (depth == m) {
            for (int val : result) System.out.print(val + " ");
            System.out.println();
            return;
        }

        // 조건에 도달하지 못해 탐색으로 이동
        for (int i = at; i <= n; i++) {
            result[depth] = i;
            // 지역변수 i 뻗어가는 노드에 + 1
            DFS(depth + 1, i + 1);
        }
    }
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        n = stdin.nextInt();
        m = stdin.nextInt();

        result = new int[m];
        visited = new boolean[n + 1];
        DFS(0, 1);
    }
}
