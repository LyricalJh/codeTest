package practice;
import java.util.*;
/**
 * 작성자: [소중한]
 * 작성일: [2024-12-19]
 * 문제 유형: [Greedy Algorithm, Dynamic Programming]
 * O표기법: [O(n log n)]
 * 문제 이름: [결혼식]
 */
class Time implements Comparable<Time>{
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

    @Override
    public int compareTo(Time o) {
        if (time == o.time) {
            return Integer.compare(status, o.status);
        }
        return Integer.compare(time, o.time);
    }
}
public class Greedy01_test01 {
    static int n;

    public static void main(String[] args) {
        List<Time> list = new ArrayList<>();
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int sT = sc.nextInt();
            int eT = sc.nextInt();
            list.add(new Time(sT , 's'));
            list.add(new Time(eT , 'e'));
        }
        Collections.sort(list);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).status == 's') {
                count++;
            } else {
                count--;
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}

/**
 * 피드백: 정렬 기준에 대한 정확한 이해도 필요함
 * 오름차순, 내림차순에 대한 정확성
 * Collections.sort() 함수에 사용법, Comparable<T> compareTo 함수
 */
