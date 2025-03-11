package object.chap1.v1;

public class BagV1 {
    private Long amount;
    private InvitationV1 invitation;
    private TicketV1 ticket;

    public BagV1(long amount) {
        this(null, amount);
    }

    public BagV1(InvitationV1 invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(TicketV1 ticket) {
        this.ticket = ticket;
    }

    public void setInvitation(InvitationV1 invitation) {
        this.invitation = invitation;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

}
