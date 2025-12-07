import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Represents a Dialogue object.
 *
 * @author Jiayin Jossie Yan
 * @version 2025
 */
public class Dialogue extends Pane {

    /**
     * Stroke width.
     */
    public static final int STROKE_WIDTH = 3;
    /**
     * Font size.
     */
    public static final int FONT_SIZE = 13;
    /**
     * Message X coordinate.
     */
    public static final int MESSAGE_X_COORDINATE = 20;
    /**
     * Message Y coordinate.
     */
    public static final int MESSAGE_Y_COORDINATE = 40;
    private Rectangle rectangleBox;
    private Text message;

    /**
     * Constructs a Dialogue box of given width and height.
     *
     * @param width of the rectangle box
     * @param height of the rectangle box
     */
    public Dialogue(final double width, final double height) {
        setPrefSize(width, height);
        setVisible(false);
        rectangleBox = new Rectangle(width, height);
        rectangleBox.setFill(Color.WHITE);
        rectangleBox.setStroke(Color.BLACK);
        rectangleBox.setStrokeWidth(STROKE_WIDTH);
        message = new Text();
        message.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FONT_SIZE));
        message.setX(MESSAGE_X_COORDINATE);
        message.setY(MESSAGE_Y_COORDINATE);
        getChildren().addAll(rectangleBox, message);
    }

    /**
     * Shows the message on the visible dialogue.
     *
     * @param text representing the message
     */
    public void showMessage(final String text) {
        message.setText(text);
        this.setVisible(true);
    }

    /**
     * Sets dialogue visibility to false.
     */
    public void hideBox() {
        this.setVisible(false);
    }

    /**
     * Returns the object as a String representation.
     *
     * @return representation of the object as a string
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Dialogue{");
        sb.append("rectangleBox=").append(rectangleBox);
        sb.append(", message=").append(message);
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

}
