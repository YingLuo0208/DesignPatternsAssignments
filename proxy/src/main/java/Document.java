import java.time.LocalDate;

public interface Document {
    String getId();
    LocalDate getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}