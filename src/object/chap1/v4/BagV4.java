package object.chap1.v4;

public class BagV4 {
    private Long amount;
    private InvitationV4 invitation;
    private TicketV4 ticket;

    public BagV4(long amount) {
        this(null, amount);
    }

    public BagV4(InvitationV4 invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public Long hold(TicketV4 ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    // 모든 내부 데이터를 다루는 메서드는 private로 외부로 노출 금지
    private boolean hasInvitation() {
        return invitation != null;
    }

    private boolean hasTicket() {
        return ticket != null;
    }

    private void setTicket(TicketV4 ticket) {
        this.ticket = ticket;
    }

    private void setInvitation(InvitationV4 invitation) {
        this.invitation = invitation;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

}
