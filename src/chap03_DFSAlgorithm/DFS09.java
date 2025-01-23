package chap03_DFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-13]
 * 문제 유형: [BFS 활용]
 * O표기법: [	O(N * M)]
 * 문제 이름: [백준 이분 그래프]
 * url : https://www.acmicpc.net/problem/1707
 */
import java.util.*;
public class DFS09 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean check;
    static int[] groups;
    static int n, k;

    public void DFS(int root, int group) {
        if (check) return;

        groups[root] = group;
        for (int neighbor : graph.get(root)) {
            // 정점과 인접이 같다면
            if (groups[root] == groups[neighbor]) check = true;
            else if (groups[neighbor] == 0) DFS(neighbor, group * (-1));
        }
    }

    public static void main(String[] args) {
        DFS09 T = new DFS09();
        Scanner stdin = new Scanner(System.in);

        k = stdin.nextInt();

        for (int j = 0; j < k; j++) {

            n = stdin.nextInt();
            int m = stdin.nextInt();
            check = false;
            groups = new int[n + 1];
            // 그래프 초기화
            graph = new ArrayList<>();
            for (int i = 0; i<= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int vertex = stdin.nextInt();
                int edge = stdin.nextInt();
                // 양방향으로 이어준다.
                graph.get(vertex).add(edge);
                graph.get(edge).add(vertex);
            }

            for (int i = 1; i <= n; i++) {
                if (groups[i] == 0) {
                    T.DFS(i, 1);
                }
            }
            if (check) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
