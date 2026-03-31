package filesystem;

/**
 * Visitor interface declaring visit methods for each type of file system element.
 * Concrete visitors must implement both methods.
 */
public interface FileSystemVisitor {
    void visit(File file);
    void visit(Directory directory);
}