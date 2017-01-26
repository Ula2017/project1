import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Chat {

    private int number;
    private Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();

    public Chat(int n)
    {
        this.number = n;
    }

    public boolean isUserInChat(Session s)
    {
        return userUsernameMap.containsKey(s);
    }

    public void removeUserFromChat(Session s)
    {
        userUsernameMap.remove(s);
    }
    public Map<Session,String> getuserUsernameMap()
    {
        return userUsernameMap;
    }
    public void addUserToChat(Session s,String username)
    {
        userUsernameMap.put(s,username);
    }

    public void broadcastMessage(String chatNumbers, String sender, String message) {
        userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                session.getRemote().sendString(newJsonString(chatNumbers,sender,message));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private String newJsonString(String a, String b, String c)
    {
        try {
            return String.valueOf(new JSONObject()
                    .put("canalList", a)
                    .put("sender", b)
                    .put("message", c));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
