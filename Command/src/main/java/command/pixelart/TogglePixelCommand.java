package command.pixelart;

/**
 * Command that toggles the pixel at the cursor's current position.
 */
public class TogglePixelCommand implements Command {

    private final PixelGrid grid;

    public TogglePixelCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.toggleCurrentPixel();
    }
}
