package chap08_BFSAlgorithm;

import java.util.*;

public class BFS13 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, answer = Integer.MIN_VALUE;
    static int[][] map;

    public boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public void bfs(int x, int y, boolean[][] visited, int waterLevel) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] > waterLevel) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public void solve() {
        for (int waterLevel = 0; waterLevel <= 100; waterLevel++) {
            boolean[][] visited = new boolean[n][n];
            int safeAreaCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 방문하지 않았고 물 높이보다 높은 지역이라면 BFS 시작
                    if (!visited[i][j] && map[i][j] > waterLevel) {
                        bfs(i, j, visited, waterLevel);
                        safeAreaCount++;
                    }
                }
            }

            // 최대 안전 영역 개수 갱신
            answer = Math.max(answer, safeAreaCount);
        }
    }

    public static void main(String[] args) {
        BFS13 T = new BFS13();
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = stdin.nextInt();
            }
        }

        T.solve();
        System.out.println(answer);
    }
}