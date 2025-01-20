package chap03_DFSAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS04 {
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int n, cnt;
    static List<Integer> result = new ArrayList<>(); // 단지 크기를 저장할 리스트

    // 유효한 좌표인지 확인
    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length && map[x][y] == 1 && !visited[x][y];
    }

    public void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny)) {
              DFS(nx, ny);
              cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        DFS04 T = new DFS04();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        // 지도 입력 받기
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = input[j]-'0';
            }
        }
        int count = 0;
        // DFS 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                  cnt = 1;
                  T.DFS(i, j);
                  count++;
                  result.add(cnt);
                }
            }
        }

        // 단지 크기 오름차순 정렬
        Collections.sort(result);
        // 단지 개수 출력
        System.out.println(count);
        // 각 단지의 크기 출력
        for (int size : result) {
            System.out.println(size);
        }
    }
}