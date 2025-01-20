package chap08_BFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-16]
 * 문제 유형: [BFS]
 * 문제 이름: [백준: 안전영역]
 * url : https://www.acmicpc.net/problem/2468
 * 문제 후기
 * 특정 조건들을 잘 이해를 못해서 원하는 정답이 나오지 않음
 * BFS 틀 잘 잡고 특정 조건에 맞게 구현의 능력을 키워야함.
 */
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