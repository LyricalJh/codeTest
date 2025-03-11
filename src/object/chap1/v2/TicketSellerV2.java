package object.chap1.v2;

import object.chap1.v1.TicketV1;

public class TicketSellerV2 {
    private TicketOfficeV2 ticketOffice;

    public TicketSellerV2(TicketOfficeV2 ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    // 기존의 Theater 가진 책임의 흐름이 TicketSellerV2 에게 넘어왔다.
    public void sellTo(AudienceV2 audience) {
        if (audience.getBag().hasInvitation()) {
            TicketV1 ticket = ticketOffice.getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            TicketV1 ticket = ticketOffice.getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }


}

