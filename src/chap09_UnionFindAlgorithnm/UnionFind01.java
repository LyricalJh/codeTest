package chap09_UnionFindAlgorithnm;
/**
 * 작성자: [소중한]
 * 작성일: [2024-12-19]
 * 문제 유형: [Union Find]
 * 문제 이름: [백준: 트리의 부모 찾기]
 */
import java.util.*;
public class UnionFind01 {
    static int n;
    static int[] parent;
    static List<List<Integer>> graph = new ArrayList<>();

    public void bfs(int start) {
        Queue<Integer> queue =new LinkedList<>();
        queue.offer(start);
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph.get(current)) {
                if (parent[next] == 0) {
                    parent[next] = current;
                    queue.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        UnionFind01 uf = new UnionFind01();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int index = scanner.nextInt();
            int value = scanner.nextInt();

            graph.get(index).add(value);
            graph.get(value).add(index);
        }
        parent[1] = 1;
        uf.bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }


    }
}
