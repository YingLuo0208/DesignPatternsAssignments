package facade.jokes.subsystems;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Subsystem: Parses a JSON string and extracts the value of a given attribute.
 */
public class JsonParser {

    public String extractAttribute(String json, String attributeName) throws IllegalArgumentException {
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        JSONObject jsonObject;

        try {
            jsonObject = (JSONObject) parser.parse(json);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse JSON response.", e);
        }

        if (!jsonObject.containsKey(attributeName)) {
            throw new IllegalArgumentException("Attribute not found in JSON: " + attributeName);
        }

        return String.valueOf(jsonObject.get(attributeName));
    }
}