package chap13_BruteForceAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-26]
 * 문제 유형: [위상정렬 Brute Force Algorithm]
 * LEVEL: 골드 3
 * 문제 이름: [백준: 치킨 배달]
 * https://www.acmicpc.net/problem/15686
 * BFS, DFS 로 치킨집 하나씩 지우면서 BFS 최소 거리 구했더니 시간 초과가남
 * 이럴때는 백트래킹을 통해 최적의 해를 구할 수 있는 경우에 탐색하여
 * 중복탐색을 방지할 수 있다.
 */
import java.util.*;
public class BF01_Backtracking {
    static int[][] map;
    static int n, m, answer = Integer.MAX_VALUE;
    static List<int[]> person = new ArrayList<>(), chicken = new ArrayList<>();
    static boolean[] visited;

    public void DFS(int start, int cnt) {
        if (cnt == m) {
            int result = 0;
            for (int[] ints : person) {
                int totalDist = Integer.MAX_VALUE;
                // 기장 최소 거리를 구한다.
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int dist = Math.abs(ints[0] - chicken.get(j)[0]) + Math.abs(ints[1] - chicken.get(j)[1]);
                        totalDist = Math.min(totalDist, dist);
                    }
                }
                result += totalDist;
            }
            answer = Math.min(answer, result);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
           visited[i] = true;
           DFS(i + 1, cnt + 1);
           visited[i] = false;
        }
    }

    public static void main(String[] args) {
        BF01_Backtracking T = new BF01_Backtracking();
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        m = stdin.nextInt();

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               map[i][j] = stdin.nextInt();
               if (map[i][j] == 1) {
                   person.add(new int[]{i, j});
               }
               if (map[i][j] == 2) {
                   chicken.add(new int[]{i,j});
               }
            }
        }
        visited = new boolean[chicken.size()];
        T.DFS(0, 0);
        System.out.println(answer);

    }
}
