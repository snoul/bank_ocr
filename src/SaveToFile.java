import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SaveToFile {

    void save() throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("accountNumbers.txt");
        System.setOut(fileStream);

    }
}