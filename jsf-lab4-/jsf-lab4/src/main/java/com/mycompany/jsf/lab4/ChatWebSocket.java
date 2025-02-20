import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.UUID;

@ServerEndpoint("/chatSocket")
public class ChatWebSocket {

    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());
    private static CopyOnWriteArrayList<String> messages = new CopyOnWriteArrayList<>();

    private static Map<Session, String> sessionUsernames = new HashMap<>();

    @OnOpen
    public void onOpen(Session session) {

        String sessionId = generateUniqueId();

        String usernameWithId = "User_" + sessionId;

        sessionUsernames.put(session, usernameWithId);

        for (String message : messages) {
            session.getAsyncRemote().sendText(message);
        }
    }

    @OnClose
    public void onClose(Session session) {

        sessions.remove(session);
        sessionUsernames.remove(session);
    }

    @OnMessage
    public void onMessage(String message, Session senderSession) {

        String username = sessionUsernames.get(senderSession);

        String formattedMessage = username + ": " + message;
  
        messages.add(formattedMessage); 

        broadcastMessage(formattedMessage);
    }

    private void broadcastMessage(String message) {
        for (Session session : sessions) {
            if (session.isOpen()) {
                session.getAsyncRemote().sendText(message);
            }
        }
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
