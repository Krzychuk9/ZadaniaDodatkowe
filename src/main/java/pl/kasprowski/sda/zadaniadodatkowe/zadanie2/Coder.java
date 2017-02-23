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
        char tmp;
        for (int i = 0; i < array.length; i++) {
            tmp = array[i];
            if ((int) tmp < 88) {
                array[i] = (char) (tmp + 3);
            } else {
                array[i] = (char) (tmp - 23);
            }
        }
        return String.valueOf(array);
    }

}
