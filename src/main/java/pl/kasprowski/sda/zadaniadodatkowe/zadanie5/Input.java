package pl.kasprowski.sda.zadaniadodatkowe.zadanie5;

import java.util.Scanner;

public class Input {

    /**
     * gets user input - start and destination points
     *
     * @return string array, array[0] - start point, array[1] - destination point
     */
    public String[] getData() {
        Scanner sc = new Scanner(System.in);
        String[] data = new String[2];

        System.out.println("Podaj pozycję wyjściową (W1-8): ");
        data[0] = sc.nextLine();
        System.out.println("Podaj pozycję końcową (W1-8): ");
        data[1] = sc.nextLine();
        return data;
    }
}
