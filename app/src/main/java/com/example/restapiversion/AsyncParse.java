package com.example.restapiversion;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


class AsyncParse extends AsyncTask <String, Void, Object>{
    private static HttpURLConnection connection;

    protected String doInBackground(String... urls) {

        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();
        try {
            URL url = new URL(urls[0]);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            //connection.setRequestProperty();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);

            int status = connection.getResponseCode();

            if (status > 299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
            return responseContent.toString();

        } catch (IOException e){
            e.printStackTrace();
            return null;
        } finally {
            connection.disconnect();
        }
    }
}
