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

public class BFS08 {
    static int answer, n, m;
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int[][] table;

    // isValid 함수 수정 (익지 않은 토마토를 찾음)
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < table.length && y < table[0].length && table[x][y] == 0;
    }

    // BFS 함수 수정
    static int bfs(List<Position1> list) {
        Queue<int[]> queue = new LinkedList<>();
        for (Position1 p : list) {
            queue.offer(new int[]{p.x, p.y});
            table[p.x][p.y] = 1;  // 초기 익은 토마토들은 이미 익은 것으로 처리
        }

        int day = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();  // 큐 크기 미리 저장

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (isValid(nx, ny)) {
                        table[nx][ny] = 1;  // 익은 토마토로 처리
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            day++;
        }

        // 모든 토마토가 익었는지 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (table[i][j] == 0) {  // 익지 않은 토마토가 있다면 -1 리턴
                    return -1;
                }
            }
        }
        return day - 1;  // 마지막에 증가한 하루를 제외하고 반환
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        List<Position1> p = new ArrayList<>();

        n = stdin.nextInt();
        m = stdin.nextInt();
        table = new int[n][m];

        // 입력 처리
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                table[i][j] = stdin.nextInt();
                if (table[i][j] == 1) {  // 익은 토마토 위치를 큐에 추가
                    p.add(new Position1(i, j));
                }
            }
        }

        answer = bfs(p);
        System.out.println(answer);
    }
}

class Position1 {
    int x, y;

    public Position1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}