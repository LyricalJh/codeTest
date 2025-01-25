package chap10_ImplAlgorithm;

import java.util.*;

public class Impl04_V1 {
    static int[] indegree, answer, time;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 개수

        for (int testCase = 0; testCase < t; testCase++) {
            // 건물 개수와 규칙 개수
            int n = sc.nextInt(); // 건물 개수
            int k = sc.nextInt(); // 규칙 개수

            indegree = new int[n + 1];
            time = new int[n + 1];

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 1; i <= n; i++) {
                time[i] = sc.nextInt();
            }

            // 건설 순서 규칙 입력
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt(); // 먼저 지어야 하는 건물
                int y = sc.nextInt(); // 나중에 지어야 하는 건물
                graph.get(x).add(y);
                indegree[y]++;
            }

            // 목표 건물
            int w = sc.nextInt();
            // 여기서부터 로직 작성

            Queue<Integer> queue = new LinkedList<>();
            answer = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                answer[i] = time[i];
                if (indegree[i] == 0) queue.offer(i);
            }

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int next : graph.get(cur)) {
                    answer[next] = Math.max(answer[next], answer[cur] + time[next]);
                    indegree[next]--;
                    if (indegree[next] == 0) queue.offer(next);
                }
            }
            System.out.println(answer[w]);
        }
        sc.close();
    }
}