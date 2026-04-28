package facade.jokes;

import facade.jokes.subsystems.HttpClient;
import facade.jokes.subsystems.JsonParser;
import facade.jokes.subsystems.ResponseHandler;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Facade implementation: composes the three subsystems to fulfill the facade interface.
 * The client never needs to interact with HttpClient, ResponseHandler, or JsonParser directly.
 */
public class ApiAccessFacade implements ApiFacade {

    private final HttpClient httpClient;
    private final ResponseHandler responseHandler;
    private final JsonParser jsonParser;

    public ApiAccessFacade() {
        this.httpClient = new HttpClient();
        this.responseHandler = new ResponseHandler();
        this.jsonParser = new JsonParser();
    }

    @Override
    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IOException, IllegalArgumentException {
        HttpURLConnection connection = httpClient.connect(urlString);
        String json = responseHandler.readResponse(connection);
        return jsonParser.extractAttribute(json, attributeName);
    }
}