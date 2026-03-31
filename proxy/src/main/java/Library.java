import java.time.LocalDate;
import java.util.HashMap;

public class Library {
    private final HashMap<String, Document> documents;

    public Library() {
        documents = new HashMap<>();
    }

    // 添加不受保护的文档
    public void addUnprotectedDocument(String id, LocalDate creationDate, String content) {
        RealDocument doc = new RealDocument(id, creationDate, content);
        documents.put(id, doc);
    }

    // 工厂方法：添加受保护的文档
    public void addProtectedDocument(String id, LocalDate creationDate, String content) {
        RealDocument realDoc = new RealDocument(id, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(realDoc);
        documents.put(id, proxy);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}