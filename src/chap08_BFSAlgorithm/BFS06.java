package chap08_BFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-13]
 * 문제 유형: [BFS 활용]
 * O표기법: [	O(N * M)]
 * 문제 이름: [백준 단지번호 붙이기]
 * url : https://www.acmicpc.net/problem/2667
 */

import java.util.*;
public class BFS06 {

    static List<Integer> answer = new ArrayList<>();
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] visited;
    static int[][] board;

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length && !visited[x][y] && board[x][y] != 0;
    }
    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 1});
        visited[startX][startY] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = x +  dx[i];
                int ny = y +  dy[i];

                if (isValid(nx, ny)) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        int totalCount = 0;
        visited = new boolean[n][n];
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = stdin.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    answer.add(bfs(i, j));
                    totalCount++;
                }
            }
        }
        System.out.println(totalCount);
        Collections.sort(answer);
        for (int houseCnt : answer) {
            System.out.println(houseCnt);
        }

    }

}
