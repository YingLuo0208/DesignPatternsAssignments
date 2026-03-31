public class AccessDeniedException extends Exception {
    public AccessDeniedException(String username, String docId) {
        super("Access denied: user '" + username + "' is not allowed to access document '" + docId + "'");
    }
}