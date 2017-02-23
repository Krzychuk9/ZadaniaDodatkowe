package pl.kasprowski.sda.zadaniadodatkowe.zadanie8;

public class Main {
    public static void main(String[] args) {
        PeselValidator validator = new PeselValidator();
        System.out.println(validator.isValid(44051401458L));
    }
}
