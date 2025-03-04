package chap13_BruteForceAlgorithm;
import java.util.*;

public class BF01_Backtracking_V3 {

    static int n, m;
    static int[] result;
    static boolean[] visited;

    public void DFS(int L) {
        if (m == L) {
            for (int val : result) System.out.print(val + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                result[L] = i;
                visited[i] = true;
                DFS(L + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        BF01_Backtracking_V3 T = new BF01_Backtracking_V3();
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        m = stdin.nextInt();

        result = new int[m];
        visited = new boolean[n + 1];
        T.DFS(0);
    }
}
