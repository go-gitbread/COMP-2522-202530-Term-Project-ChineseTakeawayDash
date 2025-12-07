import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Represents TileManager.
 *
 * @author Jiayin Jossie Yan
 * @version 2025
 */
public class TileManager {
    /**
     * Size of the tile.
     */
    public static final int TILE_SIZE = 38;
    /**
     * X coordinate of food spawn location.
     */
    private static final double KITCHEN_SPAWN_X_COORDINATE = 600;
    /**
     * Y coordinate of food spawn location.
     */
    private static final double KITCHEN_SPAWN_Y_COORDINATE = 180;
    /**
     * Max columns.
     */
    public static final int MAX_COL = 20;
    /**
     * Tiles number.
     */
    public static final int TILES_SIZE_INT = 4;
    private Pane gameRoot = new Pane();

    private final Tile[] tiles;
    private final int rows;
    private final int cols;
    private final int[][] mapTileIds;
    private final Pane mapLayer = new Pane();
    private final List<Tile> placedObjects = new ArrayList<>();
    private Furniture interactable;

    /**
     * Constructs a tile manager of specified size.
     *
     * @param rows number of rows
     * @param cols number of columns
     */
    public TileManager(final int rows, final int cols) {
        this.rows = rows;
        this.cols = cols;
        this.tiles = new Tile[TILES_SIZE_INT];
        this.mapTileIds = new int[rows][cols];
    }

    /**
     * Load the tile images for the background into the tiles.
     */
    public void loadTileImages() {
        tiles[0] = new Tile(new Image("file:src/main/resources/background/brick_walling.png"), true);
        tiles[1] = new Tile(new Image("file:src/main/resources/background/flooring.png"), false);
        tiles[2] = new Tile(new Image("file:src/main/resources/background/kitchen_flooring.png"), false);
    }

    /**
     * Adds the object to the tile manager.
     *
     * @param obj the tile
     */
    public void addObject(final Tile obj) {
        placedObjects.add(obj);
    }

    /**
     * read the map txt file into the mapTileIDs.
     *
     * @param file string of where the map.txt is
     */
    public void readMap(final String file) {
        Path filePath = Path.of(file);
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < MAX_COL) {
                for (int col = 0; col < MAX_COL; col++) {
                    char symbol = line.charAt(col);
                    if (Character.isDigit(symbol)) {
                        mapTileIds[row][col] = Character.getNumericValue(symbol);
                    } else {
                        mapTileIds[row][col] = 0;
                    }
                }
                row++;
            }
        } catch (IOException e) {
            System.err.println("Failed to read file");
        }
    }

    /**
     * Draw the map on the base pane.
     *
     * @return A pane of the rendered map
     */
    public Pane drawMap() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int tileId = mapTileIds[row][col];

                Tile tile = tiles[tileId];
                ImageView view = new ImageView(tile.getTileImage());

                view.setFitWidth(TILE_SIZE);
                view.setFitHeight(TILE_SIZE);
                view.setX(col * TILE_SIZE);
                view.setY(row * TILE_SIZE);

                mapLayer.getChildren().add(view);
            }
        }
        return mapLayer;
    }

    /**
     * Determines if the next spot the sprite is trying to go is a collision.
     *
     * @param sprite is the sprite
     * @param nextX the next hypothetical x coordinate
     * @param nextY the next hypothetical y coordinate
     * @return if the next spot if considered a collision
     */
    public boolean isCollision(final Sprite sprite,
                               final double nextX,
                               final double nextY) {
        Rectangle2D nextBounds = sprite.getBounds(nextX, nextY);

        if (checkTileMapCollision(nextBounds)) {
            return true;
        }
        for (Tile obj : placedObjects) {
            if (!obj.isCollision()) {
                continue;
            }
            Rectangle2D objBounds = new Rectangle2D(
                    obj.getTileImageView().getX(),
                    obj.getTileImageView().getY(),
                    obj.getTileImageView().getFitWidth(),
                    obj.getTileImageView().getFitHeight()
            );

            if (nextBounds.intersects(objBounds)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Returns if the future bounds are a collision.
     *
     * @param futureBounds as a rectangle
     * @return if the future bounds are a collision
     */
    private boolean checkTileMapCollision(final Rectangle2D futureBounds) {

        int leftCol = (int) (futureBounds.getMinX() / TILE_SIZE);
        int rightCol = (int) (futureBounds.getMaxX() / TILE_SIZE);
        int topRow = (int) (futureBounds.getMinY() / TILE_SIZE);
        int bottomRow = (int) (futureBounds.getMaxY() / TILE_SIZE);


        return tiles[mapTileIds[topRow][leftCol]].isCollision()
                || tiles[mapTileIds[topRow][rightCol]].isCollision()
                || tiles[mapTileIds[bottomRow][leftCol]].isCollision()
                || tiles[mapTileIds[bottomRow][rightCol]].isCollision();
    }


    /**
     * Spawn an interactable dish at the coordinates.
     */
    public void spawnDishForCustomer() {
        Dish dish = new Dish(KITCHEN_SPAWN_X_COORDINATE, KITCHEN_SPAWN_Y_COORDINATE);
        placedObjects.add(dish);
        gameRoot.getChildren().add(dish.getTileImageView());
    }


    /**
     * Return the string for the interaction if the object is interactive and in range.
     *
     * @param waiter to interacting.
     * @return the string of the interactable object
     */
    public String checkInteraction(final Waiter waiter) {

        Rectangle2D zone = waiter.getInteractionBox();

        for (Tile obj : placedObjects) {

            if (obj instanceof Interactable interactable
                    && zone.intersects(obj.getBounds())) {

                return interactable.interact(waiter);
            }
        }
        return "";
    }

    /**
     * Remove the customer from the placedObjects.
     *
     * @param customer to be removed
     */
    public void remove(final Customer customer) {
        this.placedObjects.remove(customer);
    }

    /**
     * Set up the gameRoot.
     *
     * @param root to be set
     */
    public void setGameRoot(final Pane root) {
        this.gameRoot = root;
    }

    /**
     * Returns the object as a String representation.
     *
     * @return representation of the object as a string
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("TileManager{");
        sb.append("gameRoot=").append(gameRoot);
        sb.append(", tiles=").append(Arrays.toString(tiles));
        sb.append(", rows=").append(rows);
        sb.append(", cols=").append(cols);
        sb.append(", mapTileIds=").append(Arrays.toString(mapTileIds));
        sb.append(", mapLayer=").append(mapLayer);
        sb.append(", placedObjects=").append(placedObjects);
        sb.append(", interactable=").append(interactable);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Returns true if the objects are equal, otherwise false.
     *
     * @param object the reference object with which to compare.
     * @return true if the object is equal to the comparing object
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof TileManager that)) {
            return false;
        }
        return rows == that.rows
                && cols == that.cols
                && Objects.equals(gameRoot, that.gameRoot)
                && Objects.deepEquals(tiles, that.tiles)
                && Objects.deepEquals(mapTileIds, that.mapTileIds)
                && Objects.equals(mapLayer, that.mapLayer)
                && Objects.equals(placedObjects, that.placedObjects)
                && Objects.equals(interactable, that.interactable);
    }

    /**
     * Returns the hashcode representation of the tile manager object.
     *
     * @return the hashcode of the tile manager as int
     */
    @Override
    public int hashCode() {
        return Objects.hash(gameRoot,
                Arrays.hashCode(tiles),
                rows, cols,
                Arrays.deepHashCode(mapTileIds),
                mapLayer,
                placedObjects,
                interactable);
    }
}
