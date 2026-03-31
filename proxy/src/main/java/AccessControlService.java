import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private final Set<String> allowedAccess;

    private AccessControlService() {
        allowedAccess = new HashSet<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void grantAccess(String username, String docId) {
        allowedAccess.add(username + ":" + docId);
    }

    public boolean isAllowed(String username, String docId) {
        return allowedAccess.contains(username + ":" + docId);
    }
}