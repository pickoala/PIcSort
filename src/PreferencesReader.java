import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by konstantin on 12/04/16.
 */
public class PreferencesReader {

    public String[] read() {
        File prefs = new File("folders.txt");
        String[] lines = new String[3];
        try (BufferedReader br = new BufferedReader(new FileReader(prefs)))
        {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {

                lines[i] = line;
                i++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
