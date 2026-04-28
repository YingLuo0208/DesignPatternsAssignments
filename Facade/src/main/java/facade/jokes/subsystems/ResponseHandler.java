package facade.jokes.subsystems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Subsystem: Reads the response body from an open HTTP connection.
 */
public class ResponseHandler {

    public String readResponse(HttpURLConnection connection) throws IOException {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            connection.disconnect();
        }
    }
}