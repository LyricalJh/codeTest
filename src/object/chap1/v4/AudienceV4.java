package object.chap1.v4;

public class AudienceV4 {

    private BagV4 bag;

    public AudienceV4(BagV4 bag) {
        this.bag = bag;
    }

    // 이제 관중은 bag 의 내부 구현을 모른다.
    public Long buy(TicketV4 ticket) {
        return bag.hold(ticket);
    }

}
