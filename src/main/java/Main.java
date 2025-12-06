import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Main extends Application {
    /**
     *
     */
    public static final int FIRST_TABLE_X_COORDINATE = 200;
    /**
     *
     */
    public static final int SECOND_TABLE_X_COORDINATE = 200;
    /**
     *
     */
    public static final int THIRD_TABLE_X_COORDINATE = 200;
    /**
     *
     */
    public static final int FIRST_TABLE_Y_COORDINATE = 300;
    /**
     *
     */
    public static final int SECOND_TABLE_Y_COORDINATE = 450;
    /**
     *
     */
    public static final int THIRD_TABLE_Y_COORDINATE = 600;
    private Image image1;
    private Image image2;
    private Canvas canvas;
    private Image frontSprite;
    private Image backSprite;
    private Waiter waiter;
    private Table table;
    private DirectionFace directionFace;

    @Override
    public void start(final Stage primaryStage) {

        Pane root = new Pane();
        TileManager tileManager = new TileManager(20, 20);
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

        tileManager.adObject(table1);
        tileManager.adObject(table2);
        tileManager.adObject(table3);
        // adding chairs
        Chair chair1 = new Chair(FIRST_TABLE_X_COORDINATE - 50, FIRST_TABLE_Y_COORDINATE,
                true,
                DirectionFace.RIGHT);
        Chair chair2 = new Chair(FIRST_TABLE_X_COORDINATE + 50, FIRST_TABLE_Y_COORDINATE,
                true,
                DirectionFace.LEFT);

        Chair chair3 = new Chair(SECOND_TABLE_X_COORDINATE - 50, SECOND_TABLE_Y_COORDINATE,
                true,
                DirectionFace.RIGHT);
        Chair chair4 = new Chair(THIRD_TABLE_X_COORDINATE - 50, THIRD_TABLE_Y_COORDINATE,
                true,
                DirectionFace.RIGHT);

        root.getChildren().addAll(
                chair1.getTileImageView(),
                chair2.getTileImageView(),
                chair3.getTileImageView(),
                chair4.getTileImageView()

        );

        tileManager.adObject(chair1);
        tileManager.adObject(chair2);
        tileManager.adObject(chair3);
        tileManager.adObject(chair4);


        // add all the stove
        Furniture stove2 = new Furniture(500 + 50, 100 , true, FurnitureName.STOVE);
        Furniture stove3 = new Furniture(500 + 100, 100 , true, FurnitureName.STOVE);

        root.getChildren().addAll(
                stove2.getTileImageView(),
                stove3.getTileImageView()

        );
        tileManager.adObject(stove2);
        tileManager.adObject(stove3);

        // add all the stove
        Furniture fryer = new Furniture(500 + 155, 100 , true, FurnitureName.FRYER);

        root.getChildren().addAll(
                fryer.getTileImageView()

        );
        tileManager.adObject(fryer);
        // add sink
        Furniture sink = new Furniture(500 + 170, 210, true, FurnitureName.SINK);

        root.getChildren().addAll(
                sink.getTileImageView()

        );
        tileManager.adObject(sink);

        //add the counter vertical
        Furniture vert_counter2 = new Furniture(450, 100, true, FurnitureName.VERTICAL_COUNTER);
        Furniture vert_counter3 = new Furniture(450, 180, true, FurnitureName.VERTICAL_COUNTER);
        root.getChildren().addAll(
                vert_counter2.getTileImageView(),
                vert_counter3.getTileImageView()

        );
        tileManager.adObject(vert_counter2);
        tileManager.adObject(vert_counter3);


        //add the counters horizontal
        Furniture counter1 = new Furniture(450, 255, true, FurnitureName.HORIZONTAL_COUNTER);
        Furniture counter2 = new Furniture(480 + 140, 255, true, FurnitureName.HORIZONTAL_COUNTER);

        root.getChildren().addAll(
                counter1.getTileImageView(),
                counter2.getTileImageView()
        );
        tileManager.adObject(counter1);
        tileManager.adObject(counter2);

        // add the fryer

        // add the shelf
        Furniture shelf = new Furniture(500, 70, true, FurnitureName.SHELF);
        root.getChildren().addAll(
                shelf.getTileImageView()

        );
        tileManager.adObject(shelf);


        Furniture counter3 = new Furniture(550, 500, true, FurnitureName.HORIZONTAL_COUNTER);

        root.getChildren().addAll(
                counter3.getTileImageView()

        );

        tileManager.adObject(counter3);

        // add the book on the front desk
        Furniture instructions = new Furniture(575, 500d, true, FurnitureName.INSTRUCTIONS_BOOK);

        root.getChildren().addAll(
                instructions.getTileImageView()

        );
        tileManager.adObject(instructions);

        // add plants

        Furniture plants = new Furniture(650, 500, true, FurnitureName.PLANTS);

        root.getChildren().addAll(
                plants.getTileImageView()

        );
        tileManager.adObject(plants);


        // add boxes

        Furniture boxes = new Furniture(38, 100, true, FurnitureName.BOXES);

        root.getChildren().addAll(
                boxes.getTileImageView()

        );
        tileManager.adObject(boxes);

        // add paintings

        Furniture cow_painting = new Furniture(38 * 4, 38, true, FurnitureName.COW_PAINTING);
        Furniture mountain_painting = new Furniture(38 * 7, 38, true, FurnitureName.MOUNTAIN_PAINTING);

        root.getChildren().addAll(
                cow_painting.getTileImageView(),
                mountain_painting.getTileImageView()

        );

        tileManager.adObject(cow_painting);
        tileManager.adObject(mountain_painting);



        // add waiter
        waiter = new Waiter(100, FIRST_TABLE_Y_COORDINATE + 100, tileManager);

        root.getChildren().add(waiter.getImageView());

        Scene scene = new Scene(root, 20 * 38, 20 * 38);

        scene.setOnKeyPressed(event -> {
            waiter.handleKeyPressed(event.getCode());

            if (event.getCode() == KeyCode.J) {
                waiter.interact();
            }
            System.out.println("Interaction box = " + waiter.getInteractionBox());


        });
        scene.setOnKeyReleased(event -> waiter.handleKeyReleased(event.getCode()));


        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                waiter.update();
            }
        };
        gameLoop.start();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Jossie's Diner");
        primaryStage.setResizable(true);
        primaryStage.show();

    }


    public static void main(final String[] args) {
        launch(args);
    }
}