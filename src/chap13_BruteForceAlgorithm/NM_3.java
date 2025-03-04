package chap13_BruteForceAlgorithm;

import java.util.Scanner;

public class NM_3 {

    static int n, m;
    static int[] result;


    static public void DFS(int depth) {
        if (depth == m) {
            for (int val : result) System.out.print(val + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            result[depth] = i;
            DFS(depth + 1);
        }
    }
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        m = stdin.nextInt();

        result = new int[m];
        DFS(0);
    }
}
