package practice;
import java.util.*;
/**
 * 작성자: [소중한]
 * 작성일: [2024-12-18]
 * 문제 유형: [Greedy Algorithm, Dynamic Programming]
 * O표기법: [O(n log n)]
 * 문제 이름: [최대 수입 스케줄]
 */

class Income implements Comparable<Income> {
    int income;
    int date;

    public Income(int income, int date) {
        this.income = income;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Income{" +
                "income=" + income +
                ", date=" + date +
                '}';
    }
    @Override
    public int compareTo(Income o) {
        if (this.date != o.date) {
            return Integer.compare(o.date, this.date);
        }
        return Integer.compare(o.income, this.income);
    }
}
public class Greedy02_test01 {
    static int n;

    public static void main(String[] args) {
        int answer = 0;
        List<Income> incomes = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int income = sc.nextInt();
            int date = sc.nextInt();
            incomes.add(new Income(income, date));
        }
        Collections.sort(incomes);

        int j = 0;
        int maxDate = incomes.get(0).date;
        for (int i = maxDate; i >= 1; i--) {
            for ( ; j < n; j++) {
                if (incomes.get(j).date < i) break;
                pq.offer(incomes.get(j).income);
            }
            if(!pq.isEmpty()) answer+= pq.poll();
        }
        System.out.println(answer);
    }
}
