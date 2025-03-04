package chap13_BruteForceAlgorithm;
import java.util.*;

public class BF05 {
    public static List<List<Integer>> solution(int N) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, N, 10, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(int start, int N, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= N; i++) {
            // 가자치기!
            if (i > target) continue; // 가지치기
            current.add(i);
            dfs(i + 1, N, target - i, current, result);
            current.remove(current.size() - 1); // 백트래킹
        }
    }

    public static void main(String[] args) {
        int N = 10; // 테스트 값
        List<List<Integer>> combinations = solution(N);

        for (List<Integer> combo : combinations) {
            System.out.println(combo);
        }
    }
}
