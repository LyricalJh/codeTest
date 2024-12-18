package chap01_GreedyAlgorithm;
import java.util.*;
/**
 * 작성자: [소중한]
 * 작성일: [2024-12-18]
 * 문제 유형: [Greedy Algorithm, Dynamic Programming]
 * O표기법: [O(n log n)]
 * 문제 이름: [최대 수입 스케줄]
 */
class Income {
    int income;
    int day;

    public Income(int income, int day) {
        this.income = income;
        this.day = day;
    }

    @Override
    public String toString() {
        return "Income{" +
                "income=" + income +
                ", day=" + day +
                '}';
    }
}

public class Greedy02 {
    static int n;

    public static void main(String[] args) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<Income> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int day = sc.nextInt();
            list.add(new Income(money, day));
        }

        list.sort((a,b) -> {
            if (a.day == b.day) {
                return b.income - a.income;
            }
            return b.day - a.day;
        });
        int day = list.get(0).day;
        int j = 0;
        for(int i = day; i >= 1; i--) {
            for ( ; j < n; j++) {
                if (list.get(j).day < i) break;
                pq.offer(list.get(j).income);
            }
            if (!pq.isEmpty()) answer += pq.poll();
        }
        System.out.println(answer);
    }

}
