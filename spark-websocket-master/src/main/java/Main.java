import static spark.Spark.init;
import static spark.Spark.staticFileLocation;
import static spark.Spark.webSocket;

public class Main {
    public static ChatList list;
    public static void main(String[] args) {


        list = new ChatList();
        webSocket("/public", ChatWebSocketHandler.class);
        staticFileLocation("/public/");
        init();

    }
}
