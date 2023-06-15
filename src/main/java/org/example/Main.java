package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        URL url = null;
        HttpURLConnection connection = null;
        int responseCode =0;
        String urlstring = "https://api.chucknorris.io/jokes/random";
        try {
            url = new URL(urlstring);
        } catch (MalformedURLException e) {
            System.out.println("problem in url");
        }

        //Connection
        try {
            connection = (HttpURLConnection)url.openConnection();
            responseCode = connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("connection problem");
        }

        //extract information from connection object:
        if (responseCode==200)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readLine = null;

            while((readLine = in.readLine()) != null){
                apiData.append(readLine);
            }
            in.close();
            JSONObject jsonAPIResponse = new JSONObject(apiData.toString());

            System.out.println(jsonAPIResponse.get("value"));
        }
        else
            System.out.println("API call could not be made!!!");


    }
}