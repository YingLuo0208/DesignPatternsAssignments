package command.pixelart;

/**
 * Command that moves the cursor one row downward.
 */
public class MoveCursorDownCommand implements Command {

    private final PixelGrid grid;

    public MoveCursorDownCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursorDown();
    }
}
