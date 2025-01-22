package chap03_DFSAlgorithm;
import java.util.*;
/**
 * 작성자: [소중한]
 * 작성일: [2024-01-21]
 * 문제 유형: [DFS + BFS]
 * O표기법: [O(m * a(n))]
 * 문제 이름: [백준: DFS와 BFS]
 * DFS, BFS 그래프 탐색
 * url : https://www.acmicpc.net/problem/1260
 * 문제풀이 후기
 * DFS 에는 탈줄 조건에 연연한거 같은데
 * visited 를 통해서 암묵적인 탈출조건을 만들 수 있다는 사실을 알았다.
 *
 */

public class DFS06 {
    static int vertext, edge, root;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public void DFS(int root) {
        visited[root] = true;
        System.out.print(root + " ");
        for (int next : graph.get(root)) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    public void BFS(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS06 T = new DFS06();
        Scanner stdin = new Scanner(System.in);

        vertext = stdin.nextInt();
        edge = stdin.nextInt();
        root = stdin.nextInt();

        visited = new boolean[vertext + 1];
        // 그래프 초기화
        for (int i = 0; i <= vertext; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++) {
            int index = stdin.nextInt();
            int value = stdin.nextInt();
            graph.get(index).add(value);
            graph.get(value).add(index);
        }

        for (int i = 1; i <= vertext; i++) {
            Collections.sort(graph.get(i));
        }

        T.DFS(root);
        System.out.println();
        visited = new boolean[vertext + 1];
        T.BFS(root);







    }
}
