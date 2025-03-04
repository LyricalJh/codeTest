package chap13_BruteForceAlgorithm;

import java.util.Scanner;

/**
 * 작성자: [소중한]
 * 작성일: [2025-01-25]
 * 문제 유형: [백 트래킹]
 * LEVEL: 실버 3
 * 문제 이름: [백준: N과 M (4)]
 * https://www.acmicpc.net/problem/15652
 * 문제 풀이
 * 재귀함수를 활용하여 백트래킹
 * 특정 노드 (탐색할 곳) 찾는 해가에 적합하지 않다면 부모 노드로 돌아가 다른 노드 탐색하는 알고리즘
 */
public class NM_4 {

    static int n, m;
    static int[] result;

    static public void DFS(int depth, int at) {
        if (depth == m) {
            for (int val: result) System.out.print(val + " ");
            System.out.println();
            return;
        }

        for (int i = at; i <= n; i++) {
            result[depth] = i;
            DFS(depth + 1, i);
        }
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        m = stdin.nextInt();

        result = new int[m];
        DFS(0, 1);
    }
}
