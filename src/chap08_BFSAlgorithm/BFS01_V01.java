package chap08_BFSAlgorithm;

/**
 * 작성자: [소중한]
 * 작성일: [2025-01-09]
 * 문제 유형: [DFS 활용]
 * O표기법: [	O(N * M)]
 * 문제 이름: [미로탈출]
 */
import java.util.*;

public class BFS01_V01 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static String[][] map;
    static int row, col;
    static int[] start, lever, exit;

    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length && !map[x][y].equals("X");
    }

    public int BFS(int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x == targetX && y == targetY) {
                return dist;
            }

            for (int i = 0; i <4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BFS01_V01 T = new BFS01_V01();
        String[] board = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        row = board.length;
        col = board[0].length();

        map = new String[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String[] info = board[i].split("");
            for (int j = 0; j < info.length; j++) {
                map[i][j] = info[j];
                if (info[j].equals("S")) start = new int[]{i,j};
                if (info[j].equals("L")) lever = new int[]{i,j};
                if (info[j].equals("E")) exit = new int[]{i,j};
            }
        }

        int distLever = T.BFS(start[0], start[1], lever[0], lever[1]);
        visited = new boolean[row][col];
        int distExit = T.BFS(lever[0], lever[1], exit[0], exit[1]);

        System.out.println(distLever + distExit);
    }

    // 1. 레버까지 길이를 구하기
    // 2. 레버에서 탈출구 까지 구하기

}
