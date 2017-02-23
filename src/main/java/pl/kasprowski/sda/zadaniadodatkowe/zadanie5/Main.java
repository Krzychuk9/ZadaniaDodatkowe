package pl.kasprowski.sda.zadaniadodatkowe.zadanie5;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataStructure data = new DataStructure("C:\\Users\\Admin\\IdeaProjects\\ZadaniaAdrian\\graf.txt");
        DataStructureAnalyzer analyzer = new DataStructureAnalyzer();
        Input input = new Input();

        System.out.println("Reprezentacja grafu odczytanego z pliku: ");
        data.print();

        List<Migrant> result = analyzer.analyze(data, input.getData());
        result.stream().forEach(System.out::println);
    }


}
