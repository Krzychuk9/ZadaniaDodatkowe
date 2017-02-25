package pl.kasprowski.sda.zadaniadodatkowe.zadanie2;

public class Coder {

    /**
     * encodes string with Caesar cipher
     *
     * @param s String to encode
     * @return encrypted string
     */
    public String encode(String s) {
        char[] array = s.toCharArray();
        int tmp;
        int offset = 65;
        for (int i = 0; i < array.length; i++) {
            tmp = ((int)array[i] - offset); // wiem, może trochę przekombinowane ale if ogranicza tylko do 2 rozwiązań
            array[i] = (char) (((tmp+3)%26)+offset);
        }
        return String.valueOf(array);
    }

}
