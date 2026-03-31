package filesystem;

import java.util.ArrayList;
import java.util.List;

/**
 * A concrete visitor that searches for files matching a given extension.
 *
 * Demonstrates state accumulation: matchingFiles grows as matching files are found.
 */
public class SearchVisitor implements FileSystemVisitor {

    private final String targetExtension; // e.g. ".txt", ".jpg"
    private final List<String> matchingFiles = new ArrayList<>();

    public SearchVisitor(String targetExtension) {
        this.targetExtension = targetExtension;
    }

    /**
     * Checks if the file's name ends with the target extension.
     * If it matches, records the file's name.
     */
    @Override
    public void visit(File file) {
        if (file.getName().endsWith(targetExtension)) {
            matchingFiles.add(file.getName());
        }
    }

    /**
     * Recurses into the directory's children to search all nested elements.
     */
    @Override
    public void visit(Directory directory) {
        System.out.println("Searching in directory: " + directory.getName());
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    /** Returns the list of matching file names after traversal. */
    public List<String> getMatchingFiles() {
        return matchingFiles;
    }
}