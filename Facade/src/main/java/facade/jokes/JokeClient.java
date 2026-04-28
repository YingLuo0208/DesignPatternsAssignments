package facade.jokes;

import java.io.IOException;

/**
 * Demo client: shows how the facade simplifies API access.
 * Demonstrates two APIs — Chuck Norris jokes and FX exchange rates.
 */
public class JokeClient {

    public static void main(String[] args) {
        ApiFacade facade = new ApiAccessFacade();

        // --- Demo 1: Chuck Norris Jokes API ---
        System.out.println("=== Chuck Norris Joke ===");
        try {
            String joke = facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random", "value");
            System.out.println(joke);
        } catch (IOException e) {
            System.err.println("Request failed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Attribute error: " + e.getMessage());
        }

        // --- Demo 2: FX Rates API ---
        System.out.println("\n=== FX Rates: Base Currency ===");
        try {
            String base = facade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest", "base");
            System.out.println("Base currency: " + base);
        } catch (IOException e) {
            System.err.println("Request failed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Attribute error: " + e.getMessage());
        }

        // --- Demo 3: Error handling — invalid URL ---
        System.out.println("\n=== Error Demo: Invalid URL ===");
        try {
            facade.getAttributeValueFromJson("not-a-valid-url", "value");
        } catch (IOException e) {
            System.err.println("Caught expected IOException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Attribute error: " + e.getMessage());
        }

        // --- Demo 4: Error handling — attribute not found ---
        System.out.println("\n=== Error Demo: Attribute Not Found ===");
        try {
            facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random", "nonexistent_field");
        } catch (IOException e) {
            System.err.println("Request failed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Caught expected IllegalArgumentException: " + e.getMessage());
        }
    }
}