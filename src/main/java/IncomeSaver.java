import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
/**
 * File saver class for saving income.
 *
 * @author Jossie Yan
 * @version 2025
 */
public class IncomeSaver {

    private static final Path PATH = Path.of("src/main/java/income.txt");

    /**
     * Saves income to file.
     *
     * @param income saves the value of income into income.txt file
     */
    public static void saveIncome(double income) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(PATH))) {
            writer.println(income);
            System.out.println("Income saved: " + income);
        } catch (IOException e) {
            System.out.println("not found");
        }
    }

    /**
     * Returns income value from the income.txt file otherwise return 0.
     *
     * @return the income value from the income.txt file if there is any
     */
    public static double loadIncome() {
        if (!Files.exists(PATH)) {
            System.out.println("no income found, start at 0");
            return 0;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH.toFile()))) {
            String line = reader.readLine();
            return Double.parseDouble(line);
        } catch (Exception e) {
            System.out.println("not found");
            return 0;
        }
    }

}
