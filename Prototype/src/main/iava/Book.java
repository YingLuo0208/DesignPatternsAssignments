public class Book implements Cloneable {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    // 构造函数
    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    // 拷贝构造函数（用于深拷贝）
    public Book(Book other) {
        this.title = other.title;
        this.author = other.author;
        this.genre = other.genre;
        this.publicationYear = other.publicationYear;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getPublicationYear() { return publicationYear; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setPublicationYear(int year) { this.publicationYear = year; }

    // 原型模式的 clone 方法
    @Override
    public Book clone() {
        return new Book(this);
    }

    @Override
    public String toString() {
        return String.format("\"%s\" by %s (%d) - %s",
                title, author, publicationYear, genre);
    }
}