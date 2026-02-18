package epsilon;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private Epsilon epsilon = new Epsilon("tasks.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setOnCloseRequest(event -> {
                epsilon.saveAndExit();
            });
            stage.setTitle("Epsilon");
            fxmlLoader.<MainWindow>getController().setEpsilon(epsilon); // inject the Epsilon instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
