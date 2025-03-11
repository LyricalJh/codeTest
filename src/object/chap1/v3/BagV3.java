package object.chap1.v3;

import object.chap1.v1.InvitationV1;
import object.chap1.v1.TicketV1;

public class BagV3 {
    private Long amount;
    private InvitationV3 invitation;
    private TicketV3 ticket;

    public BagV3(long amount) {
        this(null, amount);
    }

    public BagV3(InvitationV3 invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(TicketV3 ticket) {
        this.ticket = ticket;
    }

    public void setInvitation(InvitationV3 invitation) {
        this.invitation = invitation;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

}
