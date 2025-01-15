package chap08_BFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-13]
 * 문제 유형: [BFS 활용]
 * O표기법: [	O(N * M)]
 * 문제 이름: [백준 미로 탐색]
 * url : https://www.acmicpc.net/problem/2178
 */

import java.util.*;

public class BFS04 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited = new boolean[101][101];
    static int[][] board = new int[101][101];
    static int n, m;

    public boolean isValid (int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] && board[x][y] == 1;
    }

    public int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 1});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            System.out.println(cur[0] + " " + cur[1]);
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x + 1 == n  && y + 1 == m) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny)) {
                    queue.offer(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BFS04 T = new BFS04();
        Scanner stdin = new Scanner(System.in);
        n = stdin.nextInt();
        m = stdin.nextInt();

        for (int i = 0; i < n; i++) {
            String line = stdin.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int result = T.bfs(0, 0);
        System.out.println("answer : " +  result);

    }

}
