package chap10_ImplAlgorithm;

import java.util.*;

public class Impl04_V2 {
    static int[] time, indegree, answer;
    static List<List<Integer>> graph;
    static int k;

    public static void main(String[] args) {
        Impl04_V2 T = new Impl04_V2();
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            time = new int[n + 1];
            indegree = new int[n + 1];
            graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 1; j <= n; j++) {
                time[j] = sc.nextInt();
            }

            for (int j = 0; j < m; j++) {
                int vertex = sc.nextInt();
                int edge = sc.nextInt();
                graph.get(vertex).add(edge);
                indegree[edge]++;
            }
            int w = sc.nextInt();

            Queue<Integer> queue = new LinkedList<>();
            answer = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                answer[j] = time[j];
                if (indegree[j] == 0) queue.offer(j);
            }

            while(!queue.isEmpty()) {
                int cur = queue.poll();

                for (int next : graph.get(cur)) {
                    answer[next] = Math.max(answer[next], answer[cur] + time[next]);
                    indegree[next]--;
                    if (indegree[next] == 0) queue.offer(next);
                }
            }
            System.out.println(answer[w]);
        }

    }
}
