package chap03_DFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-13]
 * 문제 유형: [DFS, DP]
 * 문제 이름: [백준 내리막길]
 * url : https://www.acmicpc.net/problem/1520
 * 풀이 : DFS 방식으로는 답이 나오지 않았다. DFS + DP 방식으로 풀어야 하는데 아직 DP 풀이 방식이 온전하게 이해가 되지 않는다.
 * 따라서 제출 했을때 시간초과 발생했다. 성능을 높이기 위해서 는 결국 어딘가에 값을 저장하고 필요할때 저장한 값을 바로바로 내놓는것이
 * 성능을 올려준다는것을 깨달게 되었다.
 */
import java.util.*;
public class DFS10 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][]board;
    static int[][] dp;
    static int n, m, count = 0;

    public boolean isValid (int x, int y) {
        return x >=0 && y >=0 && x < board.length && y < board[0].length;
    }

    public boolean isLow(int x, int y, int nx, int ny) {
        return board[x][y] > board[nx][ny];
    }

    public int DFS(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            // 만약에 이미 방문했던 경로였다면 만약 그 경로가 0,0 까지 도달 했던 경로라면 1로 남겨두었겠다.
            return dp[x][y];
        }

        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx  = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny) && isLow(x, y, nx, ny)) {
                dp[x][y] += DFS(nx, ny);
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) {
        DFS10 T = new DFS10();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();

        board = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = kb.nextInt();
                dp[i][j] = -1;
            }
        }
        System.out.println(T.DFS(0,0));
    }

}
