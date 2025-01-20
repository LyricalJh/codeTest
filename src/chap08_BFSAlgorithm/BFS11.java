package chap08_BFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2024-12-19]
 * 문제 유형: [BFS + DFS]
 * 문제 이름: [백준: 벽 부수고 이동하기]
 */
import java.util.*;

public class BFS11 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] board;

    public int optimizedBFS() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];

        queue.offer(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            int wallBroken = cur[3];

            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (board[nx][ny] == 0 && !visited[nx][ny][wallBroken]) {
                        queue.offer(new int[]{nx, ny, dist + 1, wallBroken});
                        visited[nx][ny][wallBroken] = true;
                    } else if (board[nx][ny] == 1 && wallBroken == 0 && !visited[nx][ny][1]) {
                        queue.offer(new int[]{nx, ny, dist + 1, 1});
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        BFS11 T = new BFS11();
        n = stdin.nextInt();
        m = stdin.nextInt();

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = stdin.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = T.optimizedBFS();
        System.out.println(answer);
    }
}