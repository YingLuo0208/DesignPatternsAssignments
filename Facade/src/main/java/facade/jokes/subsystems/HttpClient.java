package facade.jokes.subsystems;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Subsystem: Handles opening an HTTP GET connection to a given URL.
 */
public class HttpClient {

    public HttpURLConnection connect(String urlString) throws IOException {
        URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new IOException("Invalid URL: " + urlString, e);
        }

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            connection.disconnect();
            throw new IOException("HTTP request failed with status code: " + responseCode);
        }

        return connection;
    }
}