package epsilon;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * The main JavaFX control that houses all of the other components.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Epsilon epsilon;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/user.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/epsilon.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setEpsilon(Epsilon e) {
        this.epsilon = e;
        showGreeting();
    }

    private void showGreeting() {
        String greeting = epsilon.greet();
        dialogContainer.getChildren().addAll(DialogBox.getEpsilonDialog(greeting, dukeImage));
    }

    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        List<String> response = epsilon.getResponse(input);
        String resStatus = response.get(0);
        String resMessage = response.get(1);
        dialogContainer.getChildren().addAll(
            DialogBox.getUserDialog(input, userImage)
        );

        if (resStatus.equals("Error")) {
            dialogContainer.getChildren().addAll(
                DialogBox.getEpsilonError(resMessage, dukeImage)
            );
        } else {
            dialogContainer.getChildren().addAll(
                DialogBox.getEpsilonDialog(resMessage, dukeImage)
            );
        }
        userInput.clear();
    }
}
