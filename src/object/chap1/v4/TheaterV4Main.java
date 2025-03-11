package object.chap1.v4;

import object.chap1.v2.TicketOfficeV2;

import java.time.LocalDateTime;
import java.util.Locale;

public class TheaterV4Main {
    public static void main(String[] args) {

        // given
        InvitationV4 invitationV4 = new InvitationV4(LocalDateTime.now());
        TicketV4 ticket1 = new TicketV4(100L);
        TicketV4 ticket2 = new TicketV4(100L);
        BagV4 bagV4 = new BagV4(null, 1000L);

        // when
        AudienceV4 audienceV4 = new AudienceV4(bagV4);
        TicketOfficeV4 ticketOfficeV4 = new TicketOfficeV4(1000L, ticket1, ticket2);
        TicketSellerV4 ticketSellerV4 = new TicketSellerV4(ticketOfficeV4);

        //then
        TheaterV4 theaterV4 = new TheaterV4(ticketSellerV4);
        theaterV4.enter(audienceV4);

        //result 결국적으로 티켓 어피스는 1100 이되어야 한다
        System.out.println(ticketOfficeV4);

    }
}
