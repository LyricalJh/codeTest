package chap08_BFSAlgorithm;
import java.util.*;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-09]
 * 문제 유형: [BFS 활용]
 * 문제 이름: [단어 변환]
 * 문제 레벨 : 3LEVEL
 * 문제 후기 : 문제의 풀이 의도를 이해하는게 어려웠다. 한 단어를 변환해서 단계를 거쳐 변환한다는것이 이해가 잘 되지 않았습니다.
 *
 */

class Node {
    String word;
    int count;

    public Node(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

public class BFS02 {
    static int answer, n;
    static boolean[] visited;

    public boolean isChangeAble(String current, String target) {
        int diffCnt = 0;
        for (int i = 0; i < target.length(); i++) {
            if (current.charAt(i) != target.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }

    public int Solution(String begin, String target, String[] words) {
        visited = new boolean[n];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.word.equals(target)) {
                return cur.count;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i] && isChangeAble(cur.word, words[i])) {
                    visited[i] = true;
                    q.offer(new Node(words[i], cur.count + 1));
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String target = "cog";
        n = words.length;
        answer = 0;

        BFS02 bfs = new BFS02();
        int result = bfs.Solution(begin, target, words);
        System.out.println("answer : "  + result);

    }
}
