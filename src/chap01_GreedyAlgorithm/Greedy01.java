package chap01_GreedyAlgorithm;
import java.util.*;

/**
 * 작성자: [소중한]
 * 작성일: [2024-12-18]
 * 문제 유형: [Greedy Algorithm, Dynamic Programming]
 * O표기법: [O(n log n)]
 * 문제 이름: [결혼식]
 */

class Time {
    int time;
    char status;

    public Time(int time, char status) {
        this.time = time;
        this.status = status;
    }
    @Override
    public String toString() {
        return "Time{" +
                "time=" + time +
                ", status=" + status +
                '}';
    }
}

public class Greedy01 {
    static int n;
    public static void main(String[] args) {
        int answer = Integer.MIN_VALUE;
        int count = 0;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sT = sc.nextInt();
            int eT = sc.nextInt();
            list.add(new Time(sT, 's'));
            list.add(new Time(eT, 'e'));
        }
        list.sort((a,b) -> {
            if (a.time == b.time) {
                return a.status - b.status;
            }
            return a.time - b.time;
        });

        for (Time t : list) {
            if (t.status == 's') {
                count++;
            } else {
                count--;
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

}
