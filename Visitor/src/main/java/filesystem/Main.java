package filesystem;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // --- Build the file system structure ---
        Directory root = new Directory("root");
        root.add(new File("notes.txt", 1.5));
        root.add(new File("photo.jpg", 3.2));

        Directory documents = new Directory("documents");
        documents.add(new File("report.txt", 0.8));
        documents.add(new File("summary.pdf", 1.1));

        Directory images = new Directory("images");
        images.add(new File("banner.jpg", 2.5));
        images.add(new File("icon.png", 0.3));

        root.add(documents);
        root.add(images);

        // --- Visitor 1: Calculate total size ---
        System.out.println("=== Size Calculator ===");
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.printf("Total size: %.1f MB%n%n", sizeVisitor.getTotalSize());

        // --- Visitor 2: Search for .txt files ---
        System.out.println("=== Search for .txt files ===");
        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);
        List<String> results = searchVisitor.getMatchingFiles();
        System.out.println("Found " + results.size() + " file(s): " + results);
    }
}
