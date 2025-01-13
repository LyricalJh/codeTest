package chap07_programmers;
import java.util.*;

/**
 * 작성자: [소중한]
 * 작성일: [2025-01-10]
 * 문제 유형: [그리드 알고리즘]
 * O표기법: [	O(N log N)]
 * 문제 이름: [호텔 대실]
 * 후기
 * 시간 계산할때 + 10분 이라면 시간을 60을 곱해 int 형으로 만드는 생각을 못했음 그래서 특정 케이스 실패함
 * 예약시간 기준으로 예약하는 로직까지는 작성했으나, 앞의 끝난 시간과 뒤의 시작 시간을 비교하는 로직을 떠올리지 못했음
 * 여기는 우선순위 큐를 활용하여 가장 빠른 종료시간을 구하고 리스트 순회하여 시작시간이랑 비교한다.
 */
class Room implements Comparable<Room> {

    int startTime;
    int endTime;

    public Room(String startTime, String endTime) {
        String sHour = startTime.split(":")[0];
        String sMin = startTime.split(":")[1];

        String eHour = endTime.split(":")[0];
        String eMin = endTime.split(":")[1];
        this.startTime = Integer.parseInt(sHour) * 60 + Integer.parseInt(sMin);
        this.endTime = Integer.parseInt(eHour) * 60 + Integer.parseInt(eMin);
    }

    @Override
    public int compareTo(Room o) {
        if (this.startTime == o.startTime) {
            return this.endTime - o.endTime;
        }
        return this.startTime - o.startTime;
    }
}

public class Solution03 {

    static String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};

    public static void main(String[] args) {
        int answer = 1;
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < book_time.length; i++) {
            String sp = book_time[i][0];
            String ep = book_time[i][1];
            rooms.add(new Room(sp, ep));
        }
        Collections.sort(rooms);
        // 결과 출력

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Room room : rooms) {
            while(!pq.isEmpty() && pq.peek() + 10 <= room.startTime) {
                pq.poll();
            }
            pq.add(room.endTime);
            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);

    }
}
