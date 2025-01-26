package chap13_BruteForceAlgorithm;

import java.util.Scanner;

public class BF02_Backtracking_V2 {
    static boolean[] visited;
    static int[] result;
    static int n, m;

    public void DFS(int root) {
        if (root == m) {
            for (int num : result) System.out.print(num + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[root] = i;
                DFS(root + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        BF02_Backtracking_V2 T = new BF02_Backtracking_V2();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n + 1];
        result = new int[m];

        T.DFS(0);
    }
}
