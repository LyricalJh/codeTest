package NetworkProgram.util.network.tcp.v6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SessionManagerV6 {

    private final List<SessionV6> sessions = Collections.synchronizedList(new ArrayList<>());

    public void add(SessionV6 session) {
        sessions.add(session);
    }

    public void remove(SessionV6 session) {
        sessions.remove(session);
    }

    public void closeAll() {
       synchronized (sessions) {
           for (SessionV6 session : sessions) {
               session.close();
           }
           sessions.clear();
       }
    }
}
