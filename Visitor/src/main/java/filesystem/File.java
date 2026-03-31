package filesystem;

/**
 * Represents a file in the file system.
 * Acts as a leaf node — it cannot contain other elements.
 */
public class File implements FileSystemElement {

    private final String name;
    private final double size; // size in megabytes

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    /**
     * Accepts a visitor and calls the appropriate visit() method.
     * This enables double dispatch — the visitor knows it's visiting a File.
     */
    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}