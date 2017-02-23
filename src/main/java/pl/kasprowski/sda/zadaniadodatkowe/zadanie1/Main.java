package pl.kasprowski.sda.zadaniadodatkowe.zadanie1;

public class Main {
    public static void main(String[] args) {
        AnagramValidator validator = new AnagramValidator();
        System.out.println(validator.isAnagram("pies", "kot"));
        System.out.println(validator.isAnagram("elo", "kot"));
        System.out.println(validator.isAnagram("tyran", "ranty"));
    }

}
