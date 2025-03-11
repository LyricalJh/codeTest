package object.chap1.v1;

public class TicketSellerV1 {
    private TicketOfficeV1 ticketOffice;

    public TicketSellerV1(TicketOfficeV1 ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOfficeV1 getTicketOffice() {
        return ticketOffice;
    }


}

