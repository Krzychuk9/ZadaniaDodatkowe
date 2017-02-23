package pl.kasprowski.sda.zadaniadodatkowe.zadanie4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    /**
     * Reads words from file and return them in list
     *
     * @param fileIn path to file
     * @return String list
     */
    public List<String> getWords(String fileIn) {
        List<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileIn)))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.addAll(Arrays.asList(line.split("\\s+")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

}
