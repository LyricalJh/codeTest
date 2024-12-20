package chap03_DFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2024-12-20]
 * 문제 유형: [DFS 알고리즘]
 * O표기법: [O(N)]
 * 문제 이름: [프로그래머스: 피로도]
 * 난이도 : 2LEVEL
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class DFS01 {
    static int answer;
    static boolean[] visited;

    public void DFS(int k, int L, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            int p1 = dungeons[i][0];
            int p2 = dungeons[i][1];

            if (visited[i] || k < p1) continue;

            visited[i] = true;
            DFS(k - p2, L + 1, dungeons);
            visited[i] = false;
        }
        answer = Math.max(answer, L);
    }
    public static void main(String[] args) {
        DFS01 dfs01 = new DFS01();
        int k = 80;
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};
        answer = 0;
        visited = new boolean[dungeons.length];
        dfs01.DFS(k, 0, dungeons);
        System.out.println(answer);
    }
}
