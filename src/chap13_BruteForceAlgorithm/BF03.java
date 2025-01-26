package chap13_BruteForceAlgorithm;

import java.util.Scanner;

public class BF03 {
    static int[] result;
    static int n,m;

    public void DFS(int at, int depth) {
        if (depth == m) {
            for (int val : result) System.out.print(val + " ");
            System.out.println();
            return;
        }

        for (int i = at; i <= n; i++) {
            result[depth] = i;
            DFS(i + 1,depth + 1);
        }
    }

    public static void main(String[] args) {
        BF03 T = new BF03();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        result = new int[m];
        T.DFS(1, 0);

    }
}
