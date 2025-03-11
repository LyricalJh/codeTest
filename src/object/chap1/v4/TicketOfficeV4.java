package object.chap1.v4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOfficeV4 {

    private Long amount;
    private List<TicketV4> tickets = new ArrayList<>();

    public TicketOfficeV4(Long amount, TicketV4... tickets) {
        this.amount = amount;
        this.tickets = new ArrayList<>(Arrays.asList(tickets));
    }

    // 해당 public 메서드로 서로 객체들간의 협력을 한다.
    public void sellTicketTo(AudienceV4 audienceV4) {
        plusAmount(audienceV4.buy(getTicket()));
    }

    // 내부 자원은 private 로 꼭꼭 캡슐화를 한다
    private TicketV4 getTicket() {
        return tickets.remove(0);
    }
    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    @Override
    public String toString() {
        return "TicketOfficeV4{" +
                "amount=" + amount +
                ", tickets=" + tickets +
                '}';
    }
}
