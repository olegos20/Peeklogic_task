package ua.oleh.application;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DropboxActioner {
    private  String token ="Bearer sl.AQ9Nzx7NMfnT2iG5FpomBAI5_BApLNdeFQAngjcq9YCztkFm-JNJD4omSiePtYyyJL5dla241ECcNM2kXAuC6lOdG13fv5CkL8CWkwd-m3XBuVSQWjxxcuzPzzreO1CPmiZkGFUs";
    public void createFolder(String path) throws Exception {

        try {
            URL url = new URL("https://api.dropboxapi.com/2/files/create_folder");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String parameters = "{\"path\": \"" + path + "\"}";
            conn.setRequestProperty("Content-Type", "application/json");
            conn.addRequestProperty ("Authorization", token);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
            writer.writeBytes(parameters);
            writer.flush();
            if (writer != null)
                writer.close();
            if (conn.getResponseCode() != 200) {
                System.out.println(conn.getResponseMessage());
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
