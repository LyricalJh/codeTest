package chap13_BruteForceAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-02-02]
 * 문제 유형: [위상정렬 Brute Force Algorithm]
 * LEVEL: 골드 3
 * 문제 이름: [백준: 스타트와 링크]
 * https://www.acmicpc.net/problem/14889
 * 백트래킹 문제.. 내가 제일 어려워 하는 문제유형이다.
 * 유헝을 정리하자면 문제를 읽으면 항상 조건이 있다.
 * 1. 조건 : 언제 DFS 를 종료할지.
 * 2. 해당 조건에 맞을때 각 문제에 맞는 풀이를 작성하고
 * 3. 조건 밑에 여러 방향으로 나뉘어서 가면 된다.
 */
import java.util.*;

public class BF07 {
    static int[][] board;
    static int n, answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public void diff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    start += board[i][j];
                    start += board[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += board[i][j];
                    link += board[j][i];
                }
            }
        }

        int result = Math.abs(start - link);

        if (result == 0) {
            System.out.println(result);
            System.exit(0);
        }
        answer = Math.min(result, answer);
    }

    public void DFS(int idx, int count) {
        if (count == n / 2) {
            diff();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i + 1, count + 1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        BF07 T = new BF07();
        Scanner stdin = new Scanner(System.in);

        n =  stdin.nextInt();
        visited = new boolean[n + 1];
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = stdin.nextInt();
            }
        }
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
