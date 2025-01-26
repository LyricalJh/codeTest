package chap13_BruteForceAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-26]
 * 문제 유형: [완전탐색]
 * LEVEL: 골드 5
 * 문제 이름: [백준: 치킨 배달]
 * https://www.acmicpc.net/problem/15686
 * 풀이: 백트래킹 알고리름을 활용하여 시간초과를 방지할 있음
 * 처음에는 BFS, DFS 활용하여 접근하여 풀었더니 시간 초과 발생
 * 백트래킹을 활용해야하는 이유는 최적의 해가 나오는 곳만 방문 해야하기때문
 */
import java.util.*;
public class BF01_Backtracking_V2 {
    static int[][] map;
    static boolean[] open;
    static int n, m, answer = Integer.MAX_VALUE;
    static List<int[]> house = new ArrayList<>(), chicken = new ArrayList<>();

    public void DFS(int depth, int cnt) {
        if (cnt == m) {
            // 여기서 구하는 로직
            int totalDist = 0;
            for (int i = 0; i < house.size(); i++) {
                int dist = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int tmpDist = Math.abs(house.get(i)[0] - chicken.get(j)[0]) + Math.abs(house.get(i)[1] - chicken.get(j)[1]);
                        dist = Math.min(dist, tmpDist);
                    }
                }
                totalDist += dist;
            }
            answer = Math.min(answer, totalDist);
            return;
        }

        for (int i = depth; i < chicken.size(); i++) {
            open[i] = true;
            DFS(i + 1, cnt + 1);
            open[i] = false;
        }
    }
    public static void main(String[] args) {
        BF01_Backtracking_V2 T = new BF01_Backtracking_V2();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) house.add(new int[]{i, j});
                if (map[i][j] == 2) chicken.add(new int[]{i, j});
            }
        }
        open = new boolean[chicken.size()];
        T.DFS(0, 0);
        System.out.println(answer);
    }

}
