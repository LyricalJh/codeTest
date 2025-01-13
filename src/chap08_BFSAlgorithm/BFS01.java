package chap08_BFSAlgorithm;
import java.util.*;

/**
 * 작성자: [소중한]
 * 작성일: [2025-01-09]
 * 문제 유형: [DFS 활용]
 * O표기법: [	O(N * M)]
 * 문제 이름: [미로탈출]
 */

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BFS01 {

    public int BFS(String[][] map, Position start, Position target, int rows, int cols) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(start.x, start.y));
        boolean[][] visited = new boolean[rows][cols];
        visited[start.x][start.y] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int distance = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position current = queue.poll();

                if (current.x == target.x && current.y == target.y) {
                    return distance;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = current.x + dx[j];
                    int ny = current.y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && !visited[nx][ny] && !map[nx][ny].equals("X")) {
                        queue.add(new Position(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            distance++;
        }
        return -1;
    }
    public static void main(String[] args) {
        String[] board = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        int rows = board.length;
        int cols = board[0].length();

        String[][] map = new String[rows][cols];
        Position start = null, lever = null, target = null;

        for (int i = 0; i < rows; i++) {
            String[] info = board[i].split("");
            for (int j = 0; j < info.length; j++) {
                String str = info[j];
                map[i][j] = str;
                if (str.equals("S")) start = new Position(i, j);
                if (str.equals("L")) lever = new Position(i, j);
                if (str.equals("E")) target = new Position(i, j);
            }
        }

        BFS01 T = new BFS01();
        int dis1 = T.BFS(map, start, lever, rows, cols);
        if (dis1 == -1) System.out.println(dis1);

        int dis2 = T.BFS(map, lever, target, rows, cols);
        if (dis2 == -1) System.out.println(dis2);

        System.out.println(dis1 + dis2);

    }
}
