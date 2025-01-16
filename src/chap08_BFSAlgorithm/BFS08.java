package chap08_BFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-13]
 * 문제 유형: [BFS 활용]
 * O표기법: [	O(N * M)]
 * 문제 이름: [백준 토마토]
 * url : https://www.acmicpc.net/problem/7576
 * 문제 풀이 후기
 * dis[][] 배열을 떠 올려야한다. 토마토가 익은 순간 해당 좌표에 + 1을 해줘서 최대 날자 구하기
 */
import java.util.*;

class Cod {
    int x;
    int y;

    public Cod(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
public class BFS08 {
    static int n,m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] table, dis;
    static Queue<Cod> queue = new LinkedList<>();

    public void bfs() {
        while(!queue.isEmpty()) {
            Cod current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (isValid(nx, ny)) {
                    table[nx][ny] = 1;
                    queue.offer(new Cod(nx, ny));
                    // 날짜를 하나씩 입력하는것.
                    dis[nx][ny] = dis[current.x][current.y] + 1;
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && table[x][y] == 0;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        BFS08 T = new BFS08();

        m = stdin.nextInt();
        n = stdin.nextInt();

        table = new int[n][m];
        dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                table[i][j] = stdin.nextInt();
                if (table[i][j] == 1) {
                    queue.offer(new Cod(i, j));
                }
            }
        }

        T.bfs();
        int answer = Integer.MIN_VALUE;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (table[i][j] == 0) {
                    flag = false;
                }
            }
        }

        if(flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

}