import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TileManager {
    public static final int TILE_SIZE = 38;

    private final Tile[] tiles;
    private final int rows;
    private final int cols;
    private final int[][] mapTileIds;
    private final Pane mapLayer = new Pane();
    private final List<Tile> placedObjects = new ArrayList<>();

    public TileManager(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.tiles = new Tile[4];
        this.mapTileIds = new int[rows][cols];
    }

    /**
     * Adds the object furniture to the tile manager.
     *
     * @param obj the tile
     */
    public void adObject(Tile obj) {
        placedObjects.add(obj);
    }


    public void loadTileImages() {
        tiles[0] = new Tile(new Image("file:src/main/resources/background/brick_walling.png"), true);
        tiles[1] = new Tile(new Image("file:src/main/resources/background/flooring.png"), false );
        tiles[2] = new Tile(new Image("file:src/main/resources/background/kitchen_flooring.png"), false);
    }

    /**
     * read the map txt file into the mapTileIDs
     *
     * @param file string of where the map.txt is
     */
    public void readMap(String file) {
        Path filePath = Path.of(file);
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < 20) {
                for (int col = 0; col < 20; col++) {
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

    public boolean isCollision(Sprite sprite, double nextX, double nextY) {
        Rectangle2D nextBounds = sprite.getBounds(nextX, nextY);  // NEW

        if (checkTileMapCollision(nextBounds)) {
            return true;
        }

        for (Tile obj : placedObjects) {
            if (!obj.isCollision())  {
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

    private boolean checkObjectCollision(Rectangle2D spriteBounds, Tile obj) {
        Rectangle2D objBounds = new Rectangle2D(
                obj.getTileImageView().getX(),
                obj.getTileImageView().getY(),
                obj.getTileImageView().getFitWidth(),
                obj.getTileImageView().getFitHeight()
        );

        return spriteBounds.intersects(objBounds);
    }


    private boolean checkTileMapCollision(Rectangle2D futureBounds) {

        int leftCol   = (int) (futureBounds.getMinX() / TILE_SIZE);
        int rightCol  = (int) (futureBounds.getMaxX() / TILE_SIZE);
        int topRow    = (int) (futureBounds.getMinY() / TILE_SIZE);
        int bottomRow = (int) (futureBounds.getMaxY() / TILE_SIZE);


        return tiles[mapTileIds[topRow][leftCol]].isCollision()
                || tiles[mapTileIds[topRow][rightCol]].isCollision()
                || tiles[mapTileIds[bottomRow][leftCol]].isCollision()
                || tiles[mapTileIds[bottomRow][rightCol]].isCollision();
    }


    public void checkInteraction(Waiter waiter) {

        Rectangle2D zone = waiter.getInteractionBox();

        for (Tile obj : placedObjects) {
            if (obj == null) continue;

            if (zone.intersects(obj.getBounds())) {
                obj.interact(waiter);
                return;
            }
        }

        System.out.println("Nothing...");
    }


}
