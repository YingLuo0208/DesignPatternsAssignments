package command.pixelart;

/**
 * Command that moves the cursor one row upward.
 */
public class MoveCursorUpCommand implements Command {

    private final PixelGrid grid;

    public MoveCursorUpCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursorUp();
    }
}
