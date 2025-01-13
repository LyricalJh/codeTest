package chap03_DFSAlgorithm;
/**
 * 작성자: [소중한]
 * 작성일: [2024-12-20]
 * 문제 유형: [DFS 알고리즘]
 * O표기법: [O(N)]
 * 문제 이름: [프로그래머스: 타켓 넘버]
 * 난이도 : 2LEVEL
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * 후기
 * DFS 의 이진상태 트리를 활용한 문제
 * 더하거나 빼거나
 * 이 모든 경우의 수를 합해 만들어지는 조합을 구하는 문제
 */
public class DFS02 {
    static int count;

    public void DFS(int[] numbers, int index, int target, int sum) {
        if (index == numbers.length) {
            if (target == sum) {
                count++;
            }
        } else {
            DFS(numbers, index + 1, target, sum + numbers[index]);
            DFS(numbers, index + 1, target, sum - numbers[index]);
        }
    }
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        count = 0;
        DFS02 T  = new DFS02();
        T.DFS(numbers, 0, 4, 0);
        System.out.println(count);
    }
}
