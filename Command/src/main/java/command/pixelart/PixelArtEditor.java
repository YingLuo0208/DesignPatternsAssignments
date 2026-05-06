package command.pixelart;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * JavaFX view and controller for the pixel art editor.
 *
 * <p>Layout:
 * <ul>
 *   <li>Top    – title label</li>
 *   <li>Center – 8×8 pixel canvas</li>
 *   <li>Bottom – "Create Code" button + generated-code text area</li>
 * </ul>
 *
 * <p>Keyboard bindings (grid must have focus):
 * <ul>
 *   <li>Arrow keys – move cursor</li>
 *   <li>Space      – toggle pixel at cursor</li>
 * </ul>
 */
public class PixelArtEditor extends BorderPane {

    // ── Visual constants ────────────────────────────────────────────────────
    private static final int CELL_SIZE   = 60;   // pixels per grid cell
    private static final int BORDER_SIZE = 2;    // grid-line width

    private static final Color COLOR_ON      = Color.web("#1a1a2e");   // dark navy – pixel on
    private static final Color COLOR_OFF     = Color.web("#e8e8e8");   // light grey – pixel off
    private static final Color COLOR_CURSOR  = Color.web("#e94560");   // red – cursor highlight
    private static final Color COLOR_GRID    = Color.web("#aaaaaa");   // grid lines
    private static final Color COLOR_BG      = Color.web("#f5f5f5");   // canvas background

    // ── Model ───────────────────────────────────────────────────────────────
    private final PixelGrid grid = new PixelGrid();

    // ── Commands ────────────────────────────────────────────────────────────
    private final Command moveUp    = new MoveCursorUpCommand(grid);
    private final Command moveDown  = new MoveCursorDownCommand(grid);
    private final Command moveLeft  = new MoveCursorLeftCommand(grid);
    private final Command moveRight = new MoveCursorRightCommand(grid);
    private final Command toggle    = new TogglePixelCommand(grid);
    private final GenerateCodeCommand generateCode = new GenerateCodeCommand(grid);

    // ── UI components — initialised at declaration so compiler is satisfied ──
    private final Canvas canvas = new Canvas(
            PixelGrid.SIZE * CELL_SIZE + (PixelGrid.SIZE + 1) * BORDER_SIZE,
            PixelGrid.SIZE * CELL_SIZE + (PixelGrid.SIZE + 1) * BORDER_SIZE);
    private final TextArea codeArea = new TextArea();

    public PixelArtEditor() {
        // ── Canvas setup ─────────────────────────────────────────────────────
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(this::handleKey);

        // ── Title ────────────────────────────────────────────────────────────
        Label title = new Label("🖥  Pixel Art Editor  (8×8)");
        title.setFont(Font.font("Monospaced", 20));
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: #1a1a2e;");
        title.setPadding(new Insets(12, 0, 4, 0));

        Label hint = new Label("Arrow keys: move cursor  |  Space: toggle pixel");
        hint.setStyle("-fx-text-fill: #666666; -fx-font-size: 12;");

        VBox top = new VBox(4, title, hint);
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(10, 10, 6, 10));

        // ── Button ───────────────────────────────────────────────────────────
        Button createCodeBtn = new Button("Create Code");
        createCodeBtn.setStyle(
                "-fx-background-color: #1a1a2e; -fx-text-fill: white; " +
                        "-fx-font-size: 14; -fx-padding: 8 20; -fx-cursor: hand;");
        createCodeBtn.setOnAction(e -> {
            generateCode.execute();
            codeArea.setText(generateCode.getLastGeneratedCode());
            canvas.requestFocus();   // keep keyboard focus on grid
        });

        // ── Code text area ───────────────────────────────────────────────────
        codeArea.setEditable(false);
        codeArea.setFont(Font.font("Monospaced", 13));
        codeArea.setPrefRowCount(12);
        codeArea.setWrapText(false);
        codeArea.setPromptText("Click \"Create Code\" to generate Java code…");

        VBox bottom = new VBox(10, createCodeBtn, codeArea);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(12, 20, 20, 20));

        // ── Layout ───────────────────────────────────────────────────────────
        HBox center = new HBox(canvas);
        center.setAlignment(Pos.CENTER);
        center.setPadding(new Insets(6));

        setTop(top);
        setCenter(center);
        setBottom(bottom);
        setStyle("-fx-background-color: #ffffff;");

        // Initial render
        redraw();

        // Request focus after scene is set
        canvas.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) canvas.requestFocus();
        });
    }

    // ── Input handling ───────────────────────────────────────────────────────

    private void handleKey(KeyEvent event) {
        KeyCode code = event.getCode();
        Command cmd = null;

        switch (code) {
            case UP    -> cmd = moveUp;
            case DOWN  -> cmd = moveDown;
            case LEFT  -> cmd = moveLeft;
            case RIGHT -> cmd = moveRight;
            case SPACE -> cmd = toggle;
            default    -> { /* ignore */ }
        }

        if (cmd != null) {
            cmd.execute();
            redraw();
            event.consume();   // prevent scroll-pane or other nodes from reacting
        }
    }

    // ── Rendering ────────────────────────────────────────────────────────────

    /**
     * Redraws the entire 8×8 grid on the canvas, including the cursor overlay.
     */
    private void redraw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int n = PixelGrid.SIZE;

        // Background
        gc.setFill(COLOR_BG);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                double x = col * (CELL_SIZE + BORDER_SIZE) + BORDER_SIZE;
                double y = row * (CELL_SIZE + BORDER_SIZE) + BORDER_SIZE;

                // Cell fill
                boolean on     = grid.getPixel(row, col);
                boolean cursor = (row == grid.getCursorRow() && col == grid.getCursorCol());

                gc.setFill(on ? COLOR_ON : COLOR_OFF);
                gc.fillRect(x, y, CELL_SIZE, CELL_SIZE);

                // Cursor highlight (drawn on top)
                if (cursor) {
                    gc.setStroke(COLOR_CURSOR);
                    gc.setLineWidth(3);
                    gc.strokeRect(x + 1.5, y + 1.5, CELL_SIZE - 3, CELL_SIZE - 3);
                }
            }
        }

        // Grid lines
        gc.setStroke(COLOR_GRID);
        gc.setLineWidth(BORDER_SIZE);
        for (int i = 0; i <= n; i++) {
            double pos = i * (CELL_SIZE + BORDER_SIZE);
            gc.strokeLine(pos, 0, pos, canvas.getHeight());
            gc.strokeLine(0, pos, canvas.getWidth(), pos);
        }
    }
}