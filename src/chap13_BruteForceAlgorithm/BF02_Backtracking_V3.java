package chap13_BruteForceAlgorithm;

import java.util.Scanner;

// 이번에는 중복 순열이 되도록 코드를 작성
public class BF02_Backtracking_V3 {
    static int n,m;
    static int[] result;

    public void DFS(int depth) {
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
        BF02_Backtracking_V3 T = new BF02_Backtracking_V3();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        result = new int[m];
        T.DFS(0);
    }
}
