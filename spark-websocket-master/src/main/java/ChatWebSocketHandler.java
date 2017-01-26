import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;

import java.io.IOException;
import java.net.HttpCookie;

@WebSocket
public class ChatWebSocketHandler {

    private String sender, msg;

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception {
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        switch (message.codePointAt(0)){
            case 1:

                message = message.substring(1, message.length());
                HttpCookie cookie = new HttpCookie("userName", message);
                user.getUpgradeRequest().getCookies().add(cookie);
                Main.list.adduserBeyondChat(user, message);
                Main.list.sendChatNumbers();

                break;
            case 2:

                Main.list.createNewChat();
                Main.list.sendChatNumbers();
                break;
            case 3:
                Integer nr = (Integer.valueOf (message.substring(1, message.length())));
                Main.list.addUserToChat(user,nr);
                break;
            case 4:
                Main.list.leaveChat(user);
                Main.list.sendChatNumbers();
                break;
            case 5:

                String canalNumbers = Main.list.generateList();
                Chat c = Main.list.findChatForUser(user);
                if(c!=null)
                    c.broadcastMessage(canalNumbers,sender = c.getuserUsernameMap().get(user), msg = message);
                break;
            case 6:

                String canalNumbers2 = Main.list.generateList();
                String tmp = message.substring(1, message.length());
                String response ="";
                switch (tmp)
                {
                    case "time":
                        response = Chatbot.getTime();
                        break;
                    case "weekday":
                        response = Chatbot.getDayInfo();
                        break;
                    case "weather":
                        response = Chatbot.getWeatherInfo();
                        break;
                }
                String JsonToSend = Main.list.newJsonString(canalNumbers2,tmp,response);
                try {
                    user.getRemote().sendString(JsonToSend);
                }catch (IOException ex)
                {
                }
                break;

        }
    }

}
