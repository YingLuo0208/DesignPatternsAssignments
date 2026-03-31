package filesystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a directory in the file system.
 * Acts as a composite node — it can contain files and other directories.
 */
public class Directory implements FileSystemElement {

    private final String name;
    private final List<FileSystemElement> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /** Adds a file or subdirectory to this directory. */
    public void add(FileSystemElement element) {
        children.add(element);
    }

    public List<FileSystemElement> getChildren() {
        return children;
    }

    /**
     * Accepts a visitor. The visitor is responsible for deciding
     * whether and how to recurse into children.
     */
    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}