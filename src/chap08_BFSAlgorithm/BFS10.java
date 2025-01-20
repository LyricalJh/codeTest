package chap08_BFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-16]
 * 문제 유형: [DFS + BFS]
 * 문제 이름: [백준: 연구소]
 * url : https://www.acmicpc.net/problem/14502
 */

import java.util.*;

public class BFS10 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int maxSafeZone = Integer.MIN_VALUE;
    static int[][] originMap;

    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    public void DFS(int wallCnt) {
        // 벽 3개가 된다면!
        if (wallCnt == 3) {
            BFS();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originMap[i][j] == 0) {
                    // 벽을 세우고
                    originMap[i][j] = 1;
                    DFS(wallCnt + 1);
                    // 팝 하면 다시 벽 내리고
                    originMap[i][j] = 0;
                }
            }
        }
    }

    public void BFS() {
        Queue<int[]> queue = new LinkedList<>();

        // 가스 위치 큐에 담기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originMap[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyMap[i] = originMap[i].clone();
        }

        // 가스 퍼트리기
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && copyMap[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    copyMap[nx][ny] = 2;
                }
            }
        }

        // 최대값 갱신하기
        getMaxSafeZone(copyMap);
    }

    public void getMaxSafeZone(int[][] copyMap) {
        int safeZone = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        maxSafeZone = Math.max(safeZone, maxSafeZone);
    }

    public static void main(String[] args) {
        BFS10 T = new BFS10();
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        m = stdin.nextInt();
        originMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                originMap[i][j] = stdin.nextInt();
            }
        }

        T.DFS(0);
        System.out.println(maxSafeZone);

    }

}
