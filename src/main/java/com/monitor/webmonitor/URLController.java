package com.monitor.webmonitor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class URLController {

    static int getStatusCode(String requestUrl) throws Exception {

        URL url = new URL(requestUrl);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        return responseCode;
    }

    public static String readURLContent(String urlString) throws IOException {

        URL url = new URL(urlString);
        Scanner scan = new Scanner(url.openStream());

        String content = new String();
//        long start = System.currentTimeMillis();
        while (scan.hasNext())
            content += scan.nextLine();
        scan.close();
//        long end = System.currentTimeMillis();
//        long responseTime = (end - start);
        return content;
    }
}