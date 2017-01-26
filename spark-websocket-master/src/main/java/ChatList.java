import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;
import java.net.HttpCookie;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ChatList {
    private Map<Session, String> usersBeyondCanal = new ConcurrentHashMap<>();
    private Map<Integer, Chat> chatList = new ConcurrentHashMap<>();
    private int maxCanal;


    public ChatList()
    {
        maxCanal=0;
    }

    public Chat findChatForUser(Session s)
    {
        for (Map.Entry<Integer, Chat> entry : chatList.entrySet()) {
            Chat c = entry.getValue();
            if(c.isUserInChat(s))
                return c;
        }
        return null;
    }

    public void leaveChat(Session s)
    {
        Chat c = findChatForUser(s);
        c.removeUserFromChat(s);
        usersBeyondCanal.put(s,getUsernameFromSession(s));
    }
    public void addUserToChat(Session s, int canalNr)
    {
        usersBeyondCanal.remove(s);
        Chat c = chatList.get(canalNr);
        String userName = getUsernameFromSession(s);
        c.addUserToChat(s,userName);

    }

    private String getUsernameFromSession(Session s)
    {
        int maxi = s.getUpgradeRequest().getCookies().size();
        String userName="";
        boolean b = true;
        for(int i=0;i<maxi && b;i++) {
            HttpCookie username = s.getUpgradeRequest().getCookies().get(i);
            if(username.getName()=="userName")
            {userName = username.getValue(); b = false;}
        }
        return userName;
    }

    public String generateList()
    {
        String result="";

        for (Map.Entry<Integer, Chat> entry : chatList.entrySet()) {
            String n = entry.getKey().toString();
            if (result.length() > 0)
                result += ",";
            result +=n;
        }
        return result;
    }

    private int getFirstFreeNumber ()
    {
        return ++maxCanal;
    }

    public int createNewChat()
    {
        int canalNumber = getFirstFreeNumber();
        Chat C = new Chat(canalNumber);
        chatList.put(canalNumber,C);
        return canalNumber;
    }

    public void adduserBeyondChat(Session s, String username)
    {
        usersBeyondCanal.put(s,username);
    }


    public void sendChatNumbers() {
        try {
            String JsonToSend = newJsonString(generateList(),"","");

            usersBeyondCanal.forEach((u,v) ->
                    {
                        try {
                            u.getRemote().sendString(JsonToSend);
                        } catch(Exception e){
                            e.printStackTrace();}
                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String newJsonString(String a, String b, String c)
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
