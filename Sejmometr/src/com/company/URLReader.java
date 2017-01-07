package com.company;

import java.net.*;        // konieczne do posługiwania się klasą URL
import java.io.*;

public class URLReader {

    public static String read(String urlString) throws Exception {
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
