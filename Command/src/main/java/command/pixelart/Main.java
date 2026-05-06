package command.pixelart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entry point for the Pixel Art Editor application.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        PixelArtEditor editor = new PixelArtEditor();
        Scene scene = new Scene(editor);

        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
