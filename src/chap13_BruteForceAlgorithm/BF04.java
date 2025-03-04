package chap13_BruteForceAlgorithm;

import java.util.Scanner;

public class BF04 {
    static int n,m;
    static int[] result;

    public void DFS(int at, int depth) {
        if (depth == m) {
            for (int val : result) System.out.print(val + " ");
            System.out.println();
            return;
        }

        for (int i = at ; i <= n; i++) {
            result[depth] = i;
            DFS(i, depth + 1);
        }
    }

    public static void main(String[] args) {
        BF04 T = new BF04();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        result = new int[m];
        T.DFS(1, 0);

    }
}
