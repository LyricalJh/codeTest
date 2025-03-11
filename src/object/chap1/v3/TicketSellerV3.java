package object.chap1.v3;

import object.chap1.v1.TicketV1;
import object.chap1.v2.AudienceV2;
import object.chap1.v2.TicketOfficeV2;

public class TicketSellerV3 {
    private TicketOfficeV3 ticketOffice;

    public TicketSellerV3(TicketOfficeV3 ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    // 기존의 ticketOffice 내부구현을 캡슐화 하여 TicketSellerV3 는 ticketOffice 내부구현을 알 수 없다.
    // 이제 티켓셀러는 AudienceV3 의 인터페이스 의존한다.
    public void sellTo(AudienceV3 audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    }
}

