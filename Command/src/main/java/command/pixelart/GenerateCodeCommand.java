package command.pixelart;

/**
 * Command that generates Java code for the current grid state and prints it
 * to the console. The generated code is also stored so the UI can display it.
 */
public class GenerateCodeCommand implements Command {

    private final PixelGrid grid;
    private String lastGeneratedCode = "";

    public GenerateCodeCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        lastGeneratedCode = grid.generateJavaCode();
        System.out.println(lastGeneratedCode);
    }

    /** Returns the code produced by the most recent {@link #execute()} call. */
    public String getLastGeneratedCode() {
        return lastGeneratedCode;
    }
}
