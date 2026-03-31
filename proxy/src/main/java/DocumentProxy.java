import java.time.LocalDate;

public class DocumentProxy implements Document {
    private final RealDocument realDocument;
    private final AccessControlService accessControlService;

    DocumentProxy(RealDocument realDocument) {
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public LocalDate getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (accessControlService.isAllowed(user.getUsername(), realDocument.getId())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException(user.getUsername(), realDocument.getId());
        }
    }
}