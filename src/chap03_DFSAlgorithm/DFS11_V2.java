package chap03_DFSAlgorithm;
import java.util.*;
public class DFS11_V2 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int n, m;

    public boolean isValid (int x, int y) {
        return x >= 0 && y >=0 && x < map.length && y < map[0].length;
    }

    public void meltIce() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if (map[i][j] > 0) {
                   visited[i][j] = true;
                   queue.offer(new int[]{i, j});
               }
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 여기서도 visited 검사하는 이유는 빙산이 아니였던것을 체크해야하기 때문이다.
                if (isValid(nx, ny) && map[nx][ny] == 0 && map[x][y] > 0 && !visited[nx][ny]) {
                    map[x][y] = map[x][y] - 1;
                }
            }
        }
    }

    public void DFS(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >=0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] > 0 && !visited[nx][ny]) {
                DFS(nx, ny, visited);
            }
        }
    }

    public int countIsland() {
        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    DFS(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DFS11_V2 T = new DFS11_V2();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = kb.nextInt();
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
            T.meltIce();
            year++;
        }
        System.out.println(year);
    }
}
