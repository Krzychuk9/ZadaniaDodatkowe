package pl.kasprowski.sda.zadaniadodatkowe.zadanie4;

import pl.kasprowski.sda.zadaniadodatkowe.zadanie3.WordValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Searcher {
    private Scanner sc = new Scanner(System.in);
    private List<String> words = new ArrayList<>();
    private WordValidator validator = new WordValidator();

    /**
     * Does many crazy things! Gets words from file, asks user to input word and try to find it in list of words from file
     *
     * @param fileIn path to file
     */
    public void start(String fileIn) {
        Input input = new Input();
        this.words = input.getWords(fileIn);
        do {
            System.out.println("Podaj szukane słowo: ");
            String word = sc.nextLine();

            if (words.contains(word)) {
                System.out.println("Szukane słowo \"" + word + "\" znajduje się w pliku");
                return;
            }

            int tmp = Integer.MAX_VALUE;
            String nearestWord = "";
            for (String s : words) {
                int distance = validator.getLevenshtein(word, s);
                if (distance < tmp) {
                    tmp = distance;
                    nearestWord = s;
                }
            }
            System.out.println("Czy chodziło Ci o \"" + nearestWord + "\" ? N aby kontynuować, Y aby wyjść");
            if (sc.nextLine().equalsIgnoreCase("Y")) {
                return;
            }
        } while (true);
    }

}
