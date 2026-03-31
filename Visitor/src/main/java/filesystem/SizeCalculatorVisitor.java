package filesystem;

/**
 * A concrete visitor that calculates the total size of all files
 * in the file system structure.
 *
 * Demonstrates state accumulation: totalSize grows as the visitor traverses.
 */
public class SizeCalculatorVisitor implements FileSystemVisitor {

    private double totalSize = 0.0;

    /**
     * Adds the file's size to the running total.
     */
    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    /**
     * Recurses into the directory's children to visit all nested elements.
     */
    @Override
    public void visit(Directory directory) {
        System.out.println("Entering directory: " + directory.getName());
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    /** Returns the total accumulated size after traversal. */
    public double getTotalSize() {
        return totalSize;
    }
}