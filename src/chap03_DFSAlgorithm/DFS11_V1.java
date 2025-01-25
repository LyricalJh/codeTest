package chap03_DFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-13]
 * 문제 유형: [DFS]
 * LEVEL: 골드 3
 * 문제 이름: [백준: 빙산]
 * url : https://www.acmicpc.net/problem/1520
 * 원본 iceberg 값을 지킬려고 했는데 그럴 필요없이 visited 배열 통해서 체크 하면 된다.
 */
import java.util.*;

public class DFS11_V1 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] iceberg ;
    static boolean[][] visited;
    static int[][] memo;
    static int n,m;

    public boolean isValid (int x, int y) {
        return x >= 0 && y >=0 && x < iceberg.length && y < iceberg[0].length;
    }

    public void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (iceberg[i][j] > 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        memo = new int[n][m];
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 각 사이드 바다인지 체크하고 바다라면 -1씩 녹아내림
                if (isValid(nx, ny) && iceberg[nx][ny] == 0) {
                    memo[x][y] = memo[x][y] + 1;
                }

                if (isValid(nx, ny) && iceberg[nx][ny] != 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        // 여기서 memo 값이랑 비교해서 값을 제거해놓는다. 그리고 섬이 2개인지 체크하는 로직
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                iceberg[i][j] = Math.max(0, iceberg[i][j] - memo[i][j]);
            }
        }
    }

    public int countIsland() {
        boolean[][] visited = new boolean[n][m];

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && iceberg[i][j] > 0) {
                    DFS(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void DFS(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >=0 && ny >= 0 && nx < iceberg.length && ny < iceberg[0].length && iceberg[nx][ny] > 0 && !visited[nx][ny]) {
                DFS(nx, ny, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS11_V1 T = new DFS11_V1();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();

        iceberg = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                iceberg[i][j] = kb.nextInt();
            }
        }

        int year = 0;
       while(true) {
           int result = T.countIsland();
           if (result >= 2) break;
           else if (result == 0) {
               year = 0;
               break;
           }
           T.BFS();
           year++;
       }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(iceberg[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(year);
    }

}
