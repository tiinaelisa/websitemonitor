package com.monitor.webmonitor;

import java.io.*;
import java.util.*;

public class ReadConfigFile {

    static String result = "";
    static String configFileName = "config.properties";

    private static List<URLs> allURLs = new ArrayList<>();

    public static List<URLs> getList() {

        try {
            getPropValues();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allURLs;
    }

    //read the config file
    //create new URLs with attributes url, statusCode etc.
    public static String getPropValues() throws IOException {

        //initiate the log with current date and time
        Date time = new Date(System.currentTimeMillis());
        FileWriter fileWriter = new FileWriter("monitorlog");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.write(time.toString() + "\n\n");

        try {
            Properties prop = new Properties();
            FileInputStream ip = new FileInputStream(configFileName);

            if (ip != null) {
                prop.load(ip);
            } else {
                throw new FileNotFoundException("property file ' " + configFileName +  "' not found in the classpath");
            }

            //enumerate through URLs in config file one by one
            Enumeration<String> enums = (Enumeration<String>) prop.propertyNames();
            while (enums.hasMoreElements()) {
                String key = enums.nextElement();
                String value = prop.getProperty(key);

                //split values by comma ","
                //create a new URL object
                String [] urlAndContentRequirement = value.split(",");
                String wantedURL = urlAndContentRequirement[0];
                String contentRequirement = urlAndContentRequirement[1];

                URLs url = new URLs(wantedURL, contentRequirement);
                allURLs.add(url);

                try {
                    //get the status codes
                    long statusCode = URLController.getStatusCode(wantedURL);
                    url.setStatusCode(statusCode);
                        if (statusCode!=200) {
                            url.setStatusInfo("Status was not OK, status code: " + statusCode + ". Server problem detected");
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    //get the content on the website
                    String content = URLController.readURLContent(wantedURL);

                    //compare website content with content requirement
                        if (url.getStatusCode()!=200) {
                            url.setContentInfo("Site was not available/scanned due to server error");
                        }
                        else {
                            if (content.contains(url.getContentRequirement())) {
                                url.setFoundContentAMatch(true);

                            } else {
                                url.setFoundContentAMatch(false);
                                url.setContentInfo("Content on website did not match the content requirement");

                            }
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //add URL + status to the monitorlog
                printWriter.append("URL: " + url.getUrl() + "\nStatus code: " + url.getStatusCode() +
                        "\nContent found matched required content: " + url.isFoundContentAMatch() + "\n\n");

            }

            printWriter.close();

            System.out.println(allURLs);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        return result;
    }
}
