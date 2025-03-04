package chap13_BruteForceAlgorithm;
import java.util.*;
public class BF06 {
    static int n, count = 0;
    static int[] result;

    public boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (result[col] == result[i]) return false;
            else if (Math.abs(col - i) == Math.abs(result[col] - result[i])) return false;
        }
        return true;
    }

    public void DFS(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            result[depth] = i;
            if (isPossible(depth)) DFS(depth + 1);
        }
    }
    public static void main(String[] args) {
        BF06 T = new BF06();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        result = new int[n];
        T.DFS(0);
        System.out.println(count);
    }
}
