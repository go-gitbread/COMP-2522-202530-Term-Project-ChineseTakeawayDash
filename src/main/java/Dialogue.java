import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Dialogue extends Pane {

    private Rectangle rectangleBox;
    private Text message;

    public Dialogue(double width, double height) {
        setPrefSize(width, height);
        setVisible(false);

        rectangleBox = new Rectangle(width, height);
        rectangleBox.setFill(Color.WHITE);
        rectangleBox.setStroke(Color.BLACK);
        rectangleBox.setStrokeWidth(3);

        message = new Text();
        message.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 13));
        message.setX(20);
        message.setY(40);

        getChildren().addAll(rectangleBox, message);
    }

    public void showMessage(String text) {
        message.setText(text);
        setVisible(true);
    }

    public void hideBox() {
        setVisible(false);
    }
}
