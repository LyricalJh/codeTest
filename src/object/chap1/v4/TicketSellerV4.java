package object.chap1.v4;

public class TicketSellerV4 {
    private TicketOfficeV4 ticketOffice;

    public TicketSellerV4(TicketOfficeV4 ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    // v4 에서는 ticketOffice 의 내부구현을 모르고 ticketOffice 는 자율성이 올라갔다.
    public void sellTo(AudienceV4 audience) {
        ticketOffice.sellTicketTo(audience);
    }
}

