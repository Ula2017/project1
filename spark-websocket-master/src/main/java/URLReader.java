import java.net.*;
import java.io.*;

public class URLReader {

    public static String read() throws Exception {
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=Cracow&APPID=fe0ab36b6bc2629a60f4addd5988bed7";
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String inputLine;
        StringBuilder builder = new StringBuilder();
        while ((inputLine = in.readLine()) != null){
            builder.append(inputLine);

        }
        in.close();
        return String.valueOf(builder);
    }


}