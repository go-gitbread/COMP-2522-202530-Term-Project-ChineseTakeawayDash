import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * This class sets up the game experience of Jossie's Game " Lok Lok Garden Simulation".
 * This is including tables, chairs, furniture, customers,
 * and the waiter character. It handles the game loop and user input.
 *
 * @author Jiayin Jossie Yan
 * @version 2025
 */
public class Main extends Application {
    /**
     * The x-coordinate for the first table position.
     */
    public static final int FIRST_TABLE_X_COORDINATE = 210;
    /**
     * The x-coordinate for the second table position.
     */
    public static final int SECOND_TABLE_X_COORDINATE = 210;
    /**
     * The x-coordinate for the third table position.
     */
    public static final int THIRD_TABLE_X_COORDINATE = 210;
    /**
     * The y-coordinate for the first table position.
     */
    public static final int FIRST_TABLE_Y_COORDINATE = 200;
    /**
     * The y-coordinate for the second table position.
     */
    public static final int SECOND_TABLE_Y_COORDINATE = 330;
    /**
     * The y-coordinate for the third table position.
     */
    public static final int THIRD_TABLE_Y_COORDINATE = 460;
    /**
     * Max rows/columns.
     */
    public static final int MAX_ROWS_OR_COLS = 20;
    /**
     * Offset of fifty.
     */
    public static final int OFFSET_FIFTY = 50;
    /**
     * Stove x coordinate.
     */
    public static final int STOVE_X_COORDINATE = 500;
    /**
     * Stove Y coordinate.
     */
    public static final int STOVE_Y_COORDINATE = 100;
    /**
     * Fryer offset.
     */
    public static final int FRYER_OFFSET = 155;
    /**
     * Offset of 190.
     */
    public static final int OFFSET_ONE_NINTY = 190;
    /**
     * Sink y coordinate.
     */
    public static final int SINK_Y_COORDINATE = 209;
    /**
     * Counter x coordinate.
     */
    public static final int COUNTER_X_COORDINATE = 450;
    /**
     * Counter y coordinate/
     */
    public static final int COUNTER_Y_COORDINATE = 180;
    /**
     * Horizontal counter y coordinate.
     */
    public static final int HORIZONTAL_COUNTER_Y_COORDINATE = 255;
    /**
     * Second counter x coordinate.
     */
    public static final int COUNTER_TWO_X_COORDINATE = 620;
    /**
     * Shelf y coordinate.
     */
    public static final int SHELF_Y_COORDINATE = 70;
    /**
     * General tile size.
     */
    public static final int GENERAL_TILE_SIZE = 38;
    /**
     * Max number of customers.
     */
    public static final int MAX_NUMBER_OF_CUSTOMERS = 25;
    /**
     * Customer spawn x coordinate.
     */
    public static final int CUSTOMER_SPAWN_X_COORDINATE = 610;
    /**
     * Customer spawn y coordinate.
     */
    public static final int CUSTOMER_SPAWN_Y_COORDINATE = 700;
    /**
     * Dialogue width.
     */
    public static final int WIDTH_OF_DIALOGUE = 470;
    /**
     * Dialogue y coordinate.
     */
    public static final int Y_COORDINATE_DIALOGUE = 550;
    /**
     * Four.
     */
    public static final int FOUR = 4;
    /**
     * Seven.
     */
    public static final int SEVEN = 7;
    /**
     * Plants x coordinate.
     */
    public static final int PLANTS_X_COORDINATE = 650;
    /**
     * Instructions x coordinate.
     */
    public static final int INSTRUCTIONS_X_COORDINATE = 575;
    private Image image1;
    private Image image2;
    private Canvas canvas;
    private Image frontSprite;
    private Image backSprite;
    private Waiter waiter;
    private Table table;
    private DirectionFace directionFace;
    private Dialogue dialogue;
    private boolean dialogueOpen = false;
    private TileManager tileManager;


    @Override
    public void start(final Stage primaryStage) {

        Pane root = new Pane();
        this.tileManager = new TileManager(MAX_ROWS_OR_COLS, MAX_ROWS_OR_COLS);
        tileManager.setGameRoot(root);
        tileManager.loadTileImages();
        tileManager.readMap("src/map.txt");
        Pane mapPane = tileManager.drawMap();
        root.getChildren().add(mapPane);
        // adding tables
        Table table1 = new Table(FIRST_TABLE_X_COORDINATE, FIRST_TABLE_Y_COORDINATE, true);
        Table table2 = new Table(SECOND_TABLE_X_COORDINATE, SECOND_TABLE_Y_COORDINATE, true);
        Table table3 = new Table(THIRD_TABLE_X_COORDINATE, THIRD_TABLE_Y_COORDINATE, true);
        root.getChildren().addAll(
                table1.getTileImageView(),
                table2.getTileImageView(),
                table3.getTileImageView()
        );

        tileManager.addObject(table1);
        tileManager.addObject(table2);
        tileManager.addObject(table3);
        // adding chairs
        Chair chair1 = new Chair(FIRST_TABLE_X_COORDINATE - OFFSET_FIFTY,
                FIRST_TABLE_Y_COORDINATE,
                true,
                DirectionFace.RIGHT);

        Chair chair3 = new Chair(SECOND_TABLE_X_COORDINATE - OFFSET_FIFTY,
                SECOND_TABLE_Y_COORDINATE,
                true,
                DirectionFace.RIGHT);
        Chair chair4 = new Chair(THIRD_TABLE_X_COORDINATE - OFFSET_FIFTY,
                THIRD_TABLE_Y_COORDINATE,
                true,
                DirectionFace.RIGHT);

        root.getChildren().addAll(
                chair1.getTileImageView(),
                chair3.getTileImageView(),
                chair4.getTileImageView()

        );

        tileManager.addObject(chair1);
        tileManager.addObject(chair3);
        tileManager.addObject(chair4);


        // add all the stove
        Furniture stove2 = new Furniture(STOVE_X_COORDINATE + OFFSET_FIFTY,
                STOVE_Y_COORDINATE, true, FurnitureType.STOVE);
        Furniture stove3 = new Furniture(STOVE_X_COORDINATE + STOVE_Y_COORDINATE,
                STOVE_Y_COORDINATE, true, FurnitureType.STOVE);

        root.getChildren().addAll(
                stove2.getTileImageView(),
                stove3.getTileImageView()

        );
        tileManager.addObject(stove2);
        tileManager.addObject(stove3);

        // add all the stove
        Furniture fryer = new Furniture(STOVE_X_COORDINATE + FRYER_OFFSET,
                STOVE_Y_COORDINATE, true, FurnitureType.FRYER);

        root.getChildren().addAll(
                fryer.getTileImageView()

        );
        tileManager.addObject(fryer);
        // add sink
        Furniture sink = new Furniture(STOVE_X_COORDINATE + OFFSET_ONE_NINTY,
                SINK_Y_COORDINATE, true, FurnitureType.SINK);

        root.getChildren().addAll(
                sink.getTileImageView()

        );
        tileManager.addObject(sink);

        //add the counter vertical
        Furniture vertCounter2 = new Furniture(COUNTER_X_COORDINATE,
                STOVE_Y_COORDINATE, true, FurnitureType.VERTICAL_COUNTER);
        Furniture vertCounter3 = new Furniture(COUNTER_X_COORDINATE, COUNTER_Y_COORDINATE,
                true, FurnitureType.VERTICAL_COUNTER);
        root.getChildren().addAll(
                vertCounter2.getTileImageView(),
                vertCounter3.getTileImageView()

        );
        tileManager.addObject(vertCounter2);
        tileManager.addObject(vertCounter3);


        //add the counters horizontal
        Furniture counter1 = new Furniture(COUNTER_X_COORDINATE,
                HORIZONTAL_COUNTER_Y_COORDINATE,
                true, FurnitureType.HORIZONTAL_COUNTER);
        Furniture counter2 = new Furniture(COUNTER_TWO_X_COORDINATE,
                HORIZONTAL_COUNTER_Y_COORDINATE,
                true, FurnitureType.HORIZONTAL_COUNTER);

        root.getChildren().addAll(
                counter1.getTileImageView(),
                counter2.getTileImageView()
        );
        tileManager.addObject(counter1);
        tileManager.addObject(counter2);

        // add the fryer

        // add the shelf
        Furniture shelf = new Furniture(STOVE_X_COORDINATE,
                SHELF_Y_COORDINATE, true, FurnitureType.SHELF);
        root.getChildren().addAll(
                shelf.getTileImageView()

        );
        tileManager.addObject(shelf);


        Furniture desk = new Furniture(Y_COORDINATE_DIALOGUE, STOVE_X_COORDINATE,
                true, FurnitureType.DESK);

        root.getChildren().addAll(
                desk.getTileImageView()

        );

        tileManager.addObject(desk);

        // add the book on the front desk
        Furniture instructions = new Furniture(INSTRUCTIONS_X_COORDINATE,
                STOVE_X_COORDINATE, true, FurnitureType.INSTRUCTIONS_BOOK);

        root.getChildren().addAll(
                instructions.getTileImageView()

        );
        tileManager.addObject(instructions);

        // add plants

        Furniture plants = new Furniture(PLANTS_X_COORDINATE, STOVE_X_COORDINATE,
                true, FurnitureType.PLANTS);

        root.getChildren().addAll(
                plants.getTileImageView()

        );
        tileManager.addObject(plants);


        // add boxes

        Furniture boxes = new Furniture(GENERAL_TILE_SIZE, STOVE_Y_COORDINATE,
                true, FurnitureType.BOXES);

        root.getChildren().addAll(
                boxes.getTileImageView()

        );
        tileManager.addObject(boxes);

        // add paintings

        Furniture cowPainting = new Furniture(GENERAL_TILE_SIZE * FOUR, GENERAL_TILE_SIZE,
                true, FurnitureType.COW_PAINTING);
        Furniture mountainPainting = new Furniture(GENERAL_TILE_SIZE * SEVEN,
                GENERAL_TILE_SIZE, true, FurnitureType.MOUNTAIN_PAINTING);

        root.getChildren().addAll(
                cowPainting.getTileImageView(),
                mountainPainting.getTileImageView()

        );

        tileManager.addObject(cowPainting);
        tileManager.addObject(mountainPainting);

        dialogue = new Dialogue(WIDTH_OF_DIALOGUE, COUNTER_Y_COORDINATE);
        dialogue.setLayoutX(OFFSET_FIFTY);
        dialogue.setLayoutY(Y_COORDINATE_DIALOGUE);
        root.getChildren().add(dialogue);


        //create 25 customers
        for (int i = 0; i < MAX_NUMBER_OF_CUSTOMERS; i++) {
            Customer customer = new Customer(CUSTOMER_SPAWN_X_COORDINATE, CUSTOMER_SPAWN_Y_COORDINATE);
            root.getChildren().add(customer.getTileImageView());
            tileManager.addObject(customer);
        }

        // add waiter
        waiter = new Waiter(STOVE_Y_COORDINATE, FIRST_TABLE_Y_COORDINATE + STOVE_Y_COORDINATE, tileManager);

        double savedIncome = IncomeSaver.loadIncome();
        waiter.setCurrentIncome(savedIncome);

        root.getChildren().add(waiter.getImageView());

        Scene scene = new Scene(root, MAX_ROWS_OR_COLS * GENERAL_TILE_SIZE, MAX_ROWS_OR_COLS * GENERAL_TILE_SIZE);

        scene.setOnKeyPressed(event -> handleKeyPress(event.getCode()));
        scene.setOnKeyReleased(event -> waiter.handleKeyReleased(event.getCode()));

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(final long now) {
                waiter.update();
            }
        };
        gameLoop.start();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Jossie's Lok Lok Experience");
        primaryStage.setResizable(true);
        primaryStage.show();

    }

    /**
     * Manages dialogue box toggling, income display, save functionality,
     * and waiter movement when dialogue is not open.
     *
     * @param code the pressed key
     */
    private void handleKeyPress(final KeyCode code) {
        if (!dialogueOpen && code == KeyCode.I) {
            dialogue.showMessage("Your Current Income:"
                    + waiter.getCurrentIncome());
            dialogueOpen = true;
            return;
        }
        if (dialogueOpen && code == KeyCode.I) {
            dialogue.hideBox();
            dialogueOpen = false;
            return;
        }
        if (code == KeyCode.P) {
            IncomeSaver.saveIncome(waiter.getCurrentIncome());
        }

        if (dialogueOpen && code == KeyCode.J) {
            dialogue.hideBox();
            dialogueOpen = false;
            return;
        }
        if (!dialogueOpen && code == KeyCode.J) {
            String msg = tileManager.checkInteraction(waiter);
            if (!msg.trim().isEmpty()) {
                dialogue.showMessage(msg);
                dialogueOpen = true;
            } else {
                dialogueOpen = false;
            }
            return;
        }
        if (!dialogueOpen) {
            waiter.handleKeyPressed(code);
        }
    }

    /**
     * Main entry point.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
        launch(args);
    }
}