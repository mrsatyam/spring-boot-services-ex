package com.example.finacleservice;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.security.Principal;
import java.util.List;

public class Main {
    public static void main(String[] args) throws LoginException, IOException {
    getUserPrincipals("ui","mm".toCharArray());
    }

    protected static final List<Principal> getUserPrincipals(String username, char[] password)
            throws LoginException, IOException {

        if (username == null || username.isEmpty()) {
            throw new LoginException("No username entered");
        }
        try {
            // Define the API endpoint
            URL url = new URL("https://samples.auth0.com/oauth/token");


            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();


            // Set the request method
            connection.setRequestMethod("POST");

            // Enable input and output streams
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // Set request headers
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Construct the request body
            String requestBody = "grant_type=authorization_code" +
                    "&client_id=kbyuFDidLLm280LIwVFiazOqjO3ty8KH" +
                    "&client_secret=60Op4HFM0I8ajz0WdiStAbziZ-VFQttXuxixHHs2R7r7-CW8GR79l-mmLqMhc-Sa" +
                    "&redirect_uri=https://openidconnect.net/callback" +
                    "&code=ZS-98KuSF6SL4bvl7kCGIbn2Pqlt5MMJXjTSbC5cXQdRU";

            // Write the request body to the output stream
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestBody.getBytes());
            outputStream.flush();
            outputStream.close();

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the response
            System.out.println("Response Body: " + response.toString());

            //


        } catch (Exception e) {
            throw e;
        }
        return null;

    }
}
