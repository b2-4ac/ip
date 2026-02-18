package epsilon.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Response class used for formatting outputs from commands.
 */
public class Response {

    /**
     * Formats a successful command execution response.
     *
     * @param message String that contains the response message
     *                to the user.
     * @return List object that contains success tag and message.
     */
    public static List<String> success(String message) {
        List<String> response = new ArrayList<>();
        response.add("Success");
        response.add(message);
        return response;
    }

    /**
     * Formats a failed command execution response.
     *
     * @param message String that contains the response message
     *                to the user.
     * @return List object that contains error tag and message.
     */
    public static List<String> error(String message) {
        List<String> response = new ArrayList<>();
        response.add("Error");
        response.add(message);
        return response;
    }
}
