package pl.kasprowski.sda.zadaniadodatkowe.zadanie3;

public class Main {

    public static void main(String[] args) {
        WordValidator wordValidator = new WordValidator();
        System.out.println(wordValidator.getLevenshteinSimply("granat", "granit"));
        System.out.println(wordValidator.getLevenshtein("marka", "ariada"));
    }

}
