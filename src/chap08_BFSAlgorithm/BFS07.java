package chap08_BFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-13]
 * 문제 유형: [BFS 활용]
 * O표기법: [	O(N * M)]
 * 문제 이름: [백준 유기농 배추]
 * url : https://www.acmicpc.net/problem/1012
 */
import java.util.*;

public class BFS07 {
    static List<Integer> answer = new ArrayList<>();
    static int p, n, m, k;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] board;
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m && board[x][y] != 0;
    }
    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isValid(nx, ny)) {
                    board[nx][ny] = 0;
                    queue.offer(new int[]{nx, ny});
                }

            }
        }

    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        p = stdin.nextInt();

        for (int t = 0; t < p; t++) {
            int count = 0;
            n = stdin.nextInt();
            m = stdin.nextInt();
            k = stdin.nextInt();

            board = new int[n][m];

            for (int i = 0; i < k; i++) {
                int x = stdin.nextInt();
                int y = stdin.nextInt();
                board[x][y] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            answer.add(count);
        }

        for (int value : answer) {
            System.out.println(value);
        }
    }
}
