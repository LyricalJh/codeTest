package chap01_GreedyAlgorithm;
import java.util.*;
/**
 * 작성자: [소중한]
 * 작성일: [2024-12-19]
 * 문제 유형: [Greedy Algorithm, Dynamic Programming]
 * O표기법: [O(n log n)]
 * 문제 이름: [프로그래머스: 체육복]
 */
public class Greedy03 {

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        //여벌 체육복 있는애가 도둑맞은 경우
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        //자기번호 +1, -1인 번호에게만 대여가능
        for (int k : lost) {
            for (int j = 0; j < reserve.length; j++) {
                if ((k - 1 == reserve[j]) || (k + 1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}

// 문제의 핵심포인트는 reserve 배열에서 빌려준 사람은 -1 로 치환시켜서 더이상 비교하지 않게끔 값을 변경하는것입니다.
// 이미 도난 당한 사람과, 여벌이 있는 사람을 먼저 체크한 후 나머지 작업 진행하면 됩니다.
