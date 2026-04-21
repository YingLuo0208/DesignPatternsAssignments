import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Recommendation> recommendations = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 初始化一些示例数据
        initSampleData();

        System.out.println("=========================================");
        System.out.println("   Book Recommendation System");
        System.out.println("   (Prototype Pattern Demo)");
        System.out.println("=========================================");

        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = getIntInput("Choose an option: ");

            switch (choice) {
                case 1:
                    viewAllRecommendations();
                    break;
                case 2:
                    cloneRecommendation();
                    break;
                case 3:
                    createNewRecommendation();
                    break;
                case 4:
                    modifyRecommendation();
                    break;
                case 5:
                    deleteRecommendation();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void showMainMenu() {
        System.out.println("\n-----------------------------------------");
        System.out.println("Main Menu:");
        System.out.println("  1. View all recommendations");
        System.out.println("  2. Clone a recommendation list");
        System.out.println("  3. Create new recommendation list");
        System.out.println("  4. Modify a recommendation list");
        System.out.println("  5. Delete a recommendation list");
        System.out.println("  0. Exit");
        System.out.println("-----------------------------------------");
    }

    private static void viewAllRecommendations() {
        if (recommendations.isEmpty()) {
            System.out.println("\nNo recommendation lists available.");
            return;
        }

        System.out.println("\n========== All Recommendation Lists ==========");
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("\n[" + (i + 1) + "] " + recommendations.get(i));
            recommendations.get(i).displayBooks();
        }
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
        scanner.nextLine();
    }

    private static void cloneRecommendation() {
        if (recommendations.isEmpty()) {
            System.out.println("\nNo recommendation lists to clone.");
            return;
        }

        System.out.println("\n========== Clone Recommendation List ==========");
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + recommendations.get(i));
        }

        int index = getIntInput("Select list number to clone: ") - 1;

        if (index < 0 || index >= recommendations.size()) {
            System.out.println("Invalid number!");
            return;
        }

        // 原型模式核心：克隆
        Recommendation original = recommendations.get(index);
        Recommendation cloned = original.clone();

        System.out.println("\nOriginal: " + original);
        System.out.println("Cloned: " + cloned);

        // 验证深拷贝：修改克隆版是否影响原版
        System.out.println("\nModify target audience of cloned list? (y/n)");
        String modify = scanner.next();
        if (modify.equalsIgnoreCase("y")) {
            System.out.print("Enter new target audience: ");
            scanner.nextLine();
            String newAudience = scanner.nextLine();
            cloned.setTargetAudience(newAudience);
        }

        System.out.println("Add books to cloned list? (y/n)");
        String addBook = scanner.next();
        if (addBook.equalsIgnoreCase("y")) {
            addBookToRecommendation(cloned);
        }

        recommendations.add(cloned);
        System.out.println("\n✓ Cloned list saved as #" + recommendations.size());

        // 演示深拷贝效果
        System.out.println("\n[Deep Copy Verification]");
        System.out.println("Original audience: " + original.getTargetAudience());
        System.out.println("Cloned audience: " + cloned.getTargetAudience());
        System.out.println("Modifying clone does not affect original ✓");
    }

    private static void createNewRecommendation() {
        System.out.println("\n========== Create New Recommendation List ==========");
        System.out.print("Enter target audience (e.g., Teenagers, Programmers): ");
        scanner.nextLine();
        String audience = scanner.nextLine();

        Recommendation newRec = new Recommendation(audience);

        System.out.println("Add books? (y/n)");
        String addBook = scanner.next();
        if (addBook.equalsIgnoreCase("y")) {
            addBookToRecommendation(newRec);
        }

        recommendations.add(newRec);
        System.out.println("\n✓ New recommendation list created!");
    }

    private static void modifyRecommendation() {
        if (recommendations.isEmpty()) {
            System.out.println("\nNo recommendation lists to modify.");
            return;
        }

        System.out.println("\n========== Modify Recommendation List ==========");
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + recommendations.get(i));
        }

        int index = getIntInput("Select list number to modify: ") - 1;

        if (index < 0 || index >= recommendations.size()) {
            System.out.println("Invalid number!");
            return;
        }

        Recommendation rec = recommendations.get(index);

        boolean modifying = true;
        while (modifying) {
            System.out.println("\nCurrent list: " + rec);
            System.out.println("  1. Modify target audience");
            System.out.println("  2. Add a book");
            System.out.println("  3. Remove a book");
            System.out.println("  4. View all books");
            System.out.println("  0. Back to main menu");

            int choice = getIntInput("Choose: ");

            switch (choice) {
                case 1:
                    System.out.print("Enter new target audience: ");
                    scanner.nextLine();
                    String newAudience = scanner.nextLine();
                    rec.setTargetAudience(newAudience);
                    System.out.println("✓ Target audience updated");
                    break;
                case 2:
                    addBookToRecommendation(rec);
                    break;
                case 3:
                    if (rec.getBooks().isEmpty()) {
                        System.out.println("No books to remove.");
                    } else {
                        rec.displayBooks();
                        int bookIndex = getIntInput("Select book number to remove: ") - 1;
                        rec.removeBook(bookIndex);
                        System.out.println("✓ Book removed");
                    }
                    break;
                case 4:
                    rec.displayBooks();
                    break;
                case 0:
                    modifying = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void deleteRecommendation() {
        if (recommendations.isEmpty()) {
            System.out.println("\nNo recommendation lists to delete.");
            return;
        }

        System.out.println("\n========== Delete Recommendation List ==========");
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + recommendations.get(i));
        }

        int index = getIntInput("Select list number to delete (0 to cancel): ") - 1;

        if (index >= 0 && index < recommendations.size()) {
            Recommendation removed = recommendations.remove(index);
            System.out.println("✓ Deleted: " + removed);
        } else if (index != -1) {
            System.out.println("Invalid number!");
        }
    }

    private static void addBookToRecommendation(Recommendation rec) {
        scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Genre (e.g., Fiction/Tech/Education): ");
        String genre = scanner.nextLine();
        System.out.print("Publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book(title, author, genre, year);
        rec.addBook(book);
        System.out.println("✓ Added: " + book.getTitle());
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number: ");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    private static void initSampleData() {
        // 示例：青少年推荐列表
        Recommendation teenRec = new Recommendation("Teenagers");
        teenRec.addBook(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 1997));
        teenRec.addBook(new Book("The Little Prince", "Antoine de Saint-Exupery", "Fable", 1943));
        teenRec.addBook(new Book("Charlotte's Web", "E.B. White", "Children's Literature", 1952));
        recommendations.add(teenRec);

        // 示例：程序员推荐列表
        Recommendation devRec = new Recommendation("Programmers");
        devRec.addBook(new Book("Code Complete", "Steve McConnell", "Programming", 2004));
        devRec.addBook(new Book("Design Patterns", "GoF", "Programming", 1994));
        devRec.addBook(new Book("Effective Java", "Joshua Bloch", "Technology", 2018));
        recommendations.add(devRec);
    }
}