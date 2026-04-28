package facade.jokes;

import java.io.IOException;

/**
 * Facade interface: exposes a single simplified method for API access.
 */
public interface ApiFacade {

    /**
     * Sends a GET request to the given URL, parses the JSON response,
     * and returns the value of the specified attribute.
     *
     * @param urlString     the URL to send the GET request to
     * @param attributeName the JSON attribute name to extract
     * @return the value of the attribute as a String
     * @throws IOException              if the URL is invalid or the HTTP request fails
     * @throws IllegalArgumentException if the attribute is not found in the JSON
     */
    String getAttributeValueFromJson(String urlString, String attributeName)
            throws IOException, IllegalArgumentException;
}