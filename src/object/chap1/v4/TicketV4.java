package object.chap1.v4;

public class TicketV4 {
    private Long fee;

    public TicketV4(Long fee) {
        this.fee = 100L;
    }

    public Long getFee(){
        return fee;
    }
}
