package object.chap1.v1;

public class TheaterV1 {

    private TicketSellerV1 ticketSeller;

    public TheaterV1(TicketSellerV1 ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    // TheaterV1 가 담당해야하는 부분이 너무 많은 코드 ticketSeller 의 내부구현.. 그 안의 객체의 내부구현까지 엄청나게 높은 결합도
    public void enter(AudienceV1 audience) {
        if (audience.getBag().hasInvitation()) {
            TicketV1 ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            TicketV1 ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
