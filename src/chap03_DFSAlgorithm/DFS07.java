package chap03_DFSAlgorithm;
import java.util.*;
/**
 * 작성자: [소중한]
 * 작성일: [2024-12-19]
 * 문제 유형: [DFS]
 * 문제 이름: [백준: 미로탈출]
 */

public class DFS07 {
    static String[][] map;
    static int n, m, answer = 0;
    static HashMap<String, int[]> rule = new HashMap<>();
    static boolean[][] visited;
    static boolean[][] memo;

    public boolean DFS(int x, int y) {
        // current 좌표 문자
        int[] distance = rule.get(map[x][y]);

        int nx = x + distance[0];
        int ny = y + distance[1];

        // 미로를 탈출 조건
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
            return true;
        }
        // 방문 했다면 memo 에 방문한 경로 반환
        if (visited[nx][ny]) {
            return memo[nx][ny];
        }

        // 방문하지 않았던 경로라면 방문 체크 후 memo 현재 경로 반환
        visited[nx][ny] = true;
        return memo[nx][ny] = DFS(nx, ny);
    }
    public static void main(String[] args) {
        DFS07 T = new DFS07();
        Scanner stdin = new Scanner(System.in);

        rule.put("U", new int[]{-1, 0});
        rule.put("R", new int[]{0, 1});
        rule.put("D", new int[]{1, 0});
        rule.put("L", new int[]{0, -1});

        n = stdin.nextInt();
        m = stdin.nextInt();

        map = new String[n][m];
        memo = new boolean[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = stdin.next().split("");
            for (int j = 0; j < str.length; j++) {
                map[i][j] = str[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    memo[i][j] = T.DFS(i, j);
                }

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (memo[i][j]) {
                    answer+= 1;
                }
            }
        }
        System.out.println(answer);
    }
}
