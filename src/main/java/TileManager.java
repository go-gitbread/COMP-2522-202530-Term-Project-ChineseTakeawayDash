import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TileManager {
    public static final int TILE_SIZE = 32;

    private final Tile[] tiles;
    private final int rows;
    private final int cols;
    private final int[][] mapTileIds;
    private final Pane mapLayer = new Pane();

    public TileManager(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.tiles = new Tile[4];
        this.mapTileIds = new int[rows][cols];
    }


    public void loadTileImages() {
        tiles[0] = new Tile(new Image("file:src/main/resources/brick_walling.png"), true);
        tiles[1] = new Tile(new Image("file:src/main/resources/flooring.png"), false);
        tiles[2] = new Tile(new Image("file:src/main/resources/kitchen_flooring.png"), false);
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
}
