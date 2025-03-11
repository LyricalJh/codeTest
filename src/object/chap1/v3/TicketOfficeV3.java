package object.chap1.v3;

import object.chap1.v1.TicketV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOfficeV3 {

    private Long amount;
    private List<TicketV3> tickets = new ArrayList<>();

    public TicketOfficeV3(Long amount, TicketV3 ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public TicketV3 getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }




}
