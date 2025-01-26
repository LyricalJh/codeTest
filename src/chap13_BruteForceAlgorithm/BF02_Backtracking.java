package chap13_BruteForceAlgorithm;
import java.util.*;

public class BF02_Backtracking {
    static int n, m;
    static boolean[] visited;
    static int[] result;

    public void DFS(int depth) {
        if (depth == m) {
            for (int val : result) System.out.print(val + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        BF02_Backtracking T = new BF02_Backtracking();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        result = new int[m];

        T.DFS(0);

    }
}
