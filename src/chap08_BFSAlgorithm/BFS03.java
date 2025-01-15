package chap08_BFSAlgorithm;
import java.util.*;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-13]
 * 문제 유형: [BFS 활용]
 * O표기법: [	O(N * M)]
 * 문제 이름: [아이탬 줍기]
 */
public class BFS03 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board = new int[25][25];
    static boolean[][] visited = new boolean[25][25];

    // board 주어진 직사각형 배열을 가져와서 board 에 그려주기 여기가 핵심로직!
    public void draw (int x1, int y1, int x2, int y2) {
        for (int i = x1; i<= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (board[i][j] == 1) continue;
                board[i][j] = 1;
                if (i == x1 || i == x2 || j == y1 || j == y2) {
                    board[i][j] = 2;
                }
            }
        }
    }
    // 최단경로 문제의 암기 로직 (해당 경로에 갈 수 있는지 체크 로직)
    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length && !visited[x][y] && board[x][y] == 2;
    }
    // 전형적인 BFS 풀이방식
    public int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x == endX && y == endY) {
                return dist / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny)) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        BFS03 T = new BFS03();
        int[][] rectangle = {
                {1, 1, 7, 4},
                {3, 2, 5, 5},
                {4, 3, 6, 9},
                {2, 6, 8, 8}
        };

        int startX = 1;
        int startY = 3;
        int endX = 7;
        int endY = 8;

        for (int[] rect : rectangle) {
            int x1 = rect[0];
            int y1 = rect[1];
            int x2 = rect[2];
            int y2 = rect[3];

            T.draw(x1 * 2, y1 * 2, x2 * 2, y2 * 2);
        }

        int result = T.bfs(startX * 2, startY * 2, endX * 2, endY * 2);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("answer : " + result);
    }
}
