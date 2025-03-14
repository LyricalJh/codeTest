package NetworkProgram.chat.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static NetworkProgram.util.MyLogger.log;

public class SessionManager {

    private final List<Session> sessions = new ArrayList<>();

    public SessionManager(Session session) {
        sessions.add(session);
    }

    public synchronized void add(Session session) {
        sessions.add(session);
    }

    public synchronized void remove(Session session) {
        sessions.remove(session);
    }

    public synchronized void closeAll() {
        for (Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }

    public synchronized void sendAll(String message) {
        try {
            for (Session session : sessions) {
                session.send(message);
            }
        } catch(IOException e) {
            log(e);
        }
    }

    public synchronized List<String> getAllUsername() {
        List<String> usernames = new ArrayList<>();
        for (Session session : sessions) {
            if (session.getUsername() != null) {
                usernames.add(session.getUsername());
            }
        }
        return usernames;
    }
}
