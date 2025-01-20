package chap03_DFSAlgorithm;

/**
 * 작성자: [소중한]
 * 작성일: [2024-12-20]
 * 문제 유형: [DFS 알고리즘]
 * O표기법: [O(N)]
 * 문제 이름: [프로그래머스: 두 전력망 끊기]
 * 난이도 : 2LEVEL
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
import java.util.*;

public class DFS05 {
    static int n, answer = Integer.MAX_VALUE;
    static int[] parent;

    public void init(int n) {
        for (int i =1; i <=n; i++) {
            parent[i] = i;
        }
    }
    public boolean union (int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;
        if(x < y) parent[y] = x;
        else parent[x] = y;

        return true;
    }
    public int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

    public static void main(String[] args) {
        DFS05 T = new DFS05();
        Scanner stdin = new Scanner(System.in);
        n = stdin.nextInt();

        int[][] wires = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {7, 8},
                {7, 9}
        };

        for (int i = 0; i < wires.length; i++) {
            parent = new int[n + 1];
            T.init(n);

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;

                if (T.find(wires[j][0]) != T.find(wires[j][1])) {
                    T.union(wires[j][0], wires[j][1]);
                }
            }

            Map<Integer, Integer> connect = new HashMap<>();
            for (int j = 1; j <=n; j++) {
                int root = T.find(j);
                connect.put(root, connect.getOrDefault(root, 0) + 1);
            }

            if (connect.size() == 2) {
                List<Integer> counts = new ArrayList<>(connect.values());
                int diff = Math.abs(counts.get(0) - counts.get(1));
                answer = Math.min(answer, diff);
            }
        }
        System.out.println(answer);
    }

}
