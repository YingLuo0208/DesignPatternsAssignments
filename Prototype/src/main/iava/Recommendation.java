import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    // 构造函数
    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    // 用于深拷贝的私有构造函数
    private Recommendation(String targetAudience, List<Book> books) {
        this.targetAudience = targetAudience;
        this.books = books;
    }

    // Getters
    public String getTargetAudience() { return targetAudience; }
    public List<Book> getBooks() { return new ArrayList<>(books); }

    // Setters
    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    // 书籍管理方法
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("  (No books)");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + books.get(i));
        }
    }

    // 原型模式的深拷贝方法
    @Override
    public Recommendation clone() {
        // 深拷贝：复制每本书
        List<Book> clonedBooks = new ArrayList<>();
        for (Book book : this.books) {
            clonedBooks.add(book.clone());
        }
        return new Recommendation(this.targetAudience, clonedBooks);
    }

    @Override
    public String toString() {
        return String.format("[%s] Total %d books", targetAudience, books.size());
    }
}