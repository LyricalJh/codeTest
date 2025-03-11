package object.chap1.v3;

import object.chap1.v1.BagV1;

public class AudienceV3 {

    private BagV3 bag;

    public AudienceV3(BagV3 bag) {
        this.bag = bag;
    }

    // 기존의 ticketSeller 의 계산하던 로직의 책임을 AudienceV3 에게 배분했다. 아직은 부족하다 아직도 Bag 에 대한 캡슐화가 필요하다.
    public Long buy(TicketV3 ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        } else {
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

}
