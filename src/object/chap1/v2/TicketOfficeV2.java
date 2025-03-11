package object.chap1.v2;

import object.chap1.v1.TicketV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOfficeV2 {

    private Long amount;
    private List<TicketV1> tickets = new ArrayList<>();

    public TicketOfficeV2(Long amount, TicketV1 ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public TicketV1 getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }




}
