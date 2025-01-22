package chap03_DFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-13]
 * 문제 유형: [DFS 활용]
 * 문제 이름: [백준 : 영역 구하기]
 * url : https://www.acmicpc.net/problem/2583
 * 문제후기 : 레벨 3 혹은 골드문제 정도에서 직사각형 x,y 좌표를 주고 직사각형의
 * 내부를 그리거나 혹은 직사각형의 곂쳐서 테두리 구해서 BFS 로 최단 거리 구하게 하는 경향이 종종있다.
 */
import java.util.*;

public class DFS08 {
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m, k, count = 0;

    public boolean isValid(int x, int  y) {
        return x >= 0 && y >= 0 && x< board.length && y< board[0].length;
    }

    public void DFS(int x, int y) {
        if (board[x][y] == 1) return;
        board[x][y] = 1;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny)) {
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        DFS08 T = new DFS08();
        Scanner stdin = new Scanner(System.in);
        n = stdin.nextInt();
        m = stdin.nextInt();
        k = stdin.nextInt();

        board = new int[n][m];

        for (int i = 0; i < k; i++) {
            int x1 = stdin.nextInt();
            int y1 = stdin.nextInt();
            int x2 = stdin.nextInt();
            int y2 = stdin.nextInt();

            // 이 부분은 외워야 할듯 꼭지점 x, y 주어질때 이렇게 직사각형 구하는것
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = 1; // 직사각형 시작 부분 1로 변경
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    count = 0;
                    T.DFS(i, j);
                    result.add(count);
                }
            }
        }
        Collections.sort(result);

        System.out.println(result.size());
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}
