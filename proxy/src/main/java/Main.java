import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 设置访问权限
        AccessControlService acs = AccessControlService.getInstance();
        acs.grantAccess("alice", "doc1");
        acs.grantAccess("alice", "doc2");
        acs.grantAccess("bob", "doc2");

        // 创建文档库
        Library library = new Library();
        library.addUnprotectedDocument("doc0", LocalDate.of(2024, 1, 1), "This is a public document.");
        library.addProtectedDocument("doc1", LocalDate.of(2024, 3, 15), "This is a secret document for alice.");
        library.addProtectedDocument("doc2", LocalDate.of(2024, 6, 20), "This is a shared secret for alice and bob.");

        // 创建用户
        User alice = new User("alice");
        User bob = new User("bob");
        User charlie = new User("charlie");

        System.out.println("=== Unprotected Document ===");
        testAccess(library.getDocument("doc0"), alice);
        testAccess(library.getDocument("doc0"), charlie);

        System.out.println("\n=== Protected Document (doc1) ===");
        testAccess(library.getDocument("doc1"), alice);
        testAccess(library.getDocument("doc1"), bob);
        testAccess(library.getDocument("doc1"), charlie);

        System.out.println("\n=== Protected Document (doc2) ===");
        testAccess(library.getDocument("doc2"), alice);
        testAccess(library.getDocument("doc2"), bob);
        testAccess(library.getDocument("doc2"), charlie);
    }

    private static void testAccess(Document doc, User user) {
        System.out.println("\nUser: " + user.getUsername());
        System.out.println("Document ID: " + doc.getId());
        System.out.println("Creation Date: " + doc.getCreationDate());
        try {
            String content = doc.getContent(user);
            System.out.println("Content: " + content);
        } catch (AccessDeniedException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}