package chap08_BFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-13]
 * 문제 유형: [Union Find]
 * 문제 이름: [백준 연결요소 요소의 개수]
 * url : https://www.acmicpc.net/problem/11724
 */

import java.util.*;

public class BFS09 {
    static int n,m;
    static int[] parent;

    public boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;
        // 숫자가 더 큰것이 노드가 되고 작은값이 노드의 값이 된다.
        if (x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    public int find(int x) {
        // root 찾음
        if (parent[x] == x) return x;
        // 해당 Index 값으로 root 서치
        return find(parent[x]);
    }

    public static void printParent() {
        System.out.print("[ ");
        for (int i = 1; i < parent.length; i++) {
            System.out.print(parent[i]+ " ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        BFS09 T = new BFS09();
        Scanner stdin = new Scanner(System.in);

        Set<Integer> answer = new HashSet<>();
        n = stdin.nextInt();
        m = stdin.nextInt();

        parent = new int[n+1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            T.union(stdin.nextInt(), stdin.nextInt());
        }
        for (int i = 1; i < parent.length; i++) {
            answer.add(T.find(parent[i]));
        }

        System.out.println(answer.size());

    }
}
