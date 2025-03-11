package object.chap1.v2;

import object.chap1.v1.AudienceV1;

public class TheaterV2 {

    private TicketSellerV2 ticketSeller;

    public TheaterV2(TicketSellerV2 ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    // 이제 TheaterV2는 ticketSeller 의 내부구현에 대해 알 수 없다.
    public void enter(AudienceV2 audience) {
        // 기존의 코드를 캡슐화 진행 Theater 객체는 ticketSeller 의 세세한 내부 구현을 알 필요가 없다.
        ticketSeller.sellTo(audience);
    }
}
