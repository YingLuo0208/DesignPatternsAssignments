package command.pixelart;

/**
 * Model class representing the 8x8 pixel grid and cursor state.
 */
public class PixelGrid {

    public static final int SIZE = 8;

    private final boolean[][] pixels = new boolean[SIZE][SIZE];
    private int cursorRow = 0;
    private int cursorCol = 0;

    // ── Cursor accessors ────────────────────────────────────────────────────

    public int getCursorRow() { return cursorRow; }
    public int getCursorCol() { return cursorCol; }

    public void moveCursorUp()    { cursorRow = Math.max(0, cursorRow - 1); }
    public void moveCursorDown()  { cursorRow = Math.min(SIZE - 1, cursorRow + 1); }
    public void moveCursorLeft()  { cursorCol = Math.max(0, cursorCol - 1); }
    public void moveCursorRight() { cursorCol = Math.min(SIZE - 1, cursorCol + 1); }

    // ── Pixel accessors ─────────────────────────────────────────────────────

    public boolean getPixel(int row, int col) { return pixels[row][col]; }

    public void togglePixel(int row, int col) { pixels[row][col] = !pixels[row][col]; }

    public void toggleCurrentPixel() { togglePixel(cursorRow, cursorCol); }

    // ── Code generation ─────────────────────────────────────────────────────

    /**
     * Generates a Java int[][] literal that represents the current grid state.
     * '1' = pixel on, '0' = pixel off.
     */
    public String generateJavaCode() {
        StringBuilder sb = new StringBuilder();
        sb.append("int[][] pixelArt = {\n");
        for (int row = 0; row < SIZE; row++) {
            sb.append("    {");
            for (int col = 0; col < SIZE; col++) {
                sb.append(pixels[row][col] ? "1" : "0");
                if (col < SIZE - 1) sb.append(", ");
            }
            sb.append("}");
            if (row < SIZE - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("};");
        return sb.toString();
    }
}
