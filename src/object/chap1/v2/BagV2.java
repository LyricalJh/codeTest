package object.chap1.v2;

import object.chap1.v1.InvitationV1;
import object.chap1.v1.TicketV1;

public class BagV2 {
    private Long amount;
    private InvitationV1 invitation;
    private TicketV1 ticket;

    public BagV2(long amount) {
        this(null, amount);
    }

    public BagV2(InvitationV1 invitation, long amount) {
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
