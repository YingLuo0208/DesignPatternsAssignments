package filesystem;

/**
 * Base interface for all file system elements (files and directories).
 * Declares the accept() method required by the Visitor pattern.
 */
public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}