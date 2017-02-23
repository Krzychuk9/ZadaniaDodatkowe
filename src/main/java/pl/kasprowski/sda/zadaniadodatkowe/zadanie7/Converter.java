package pl.kasprowski.sda.zadaniadodatkowe.zadanie7;

import java.util.*;

public class Converter {
    private Map<Character, Integer> map = new HashMap<>();
    private Map<String, Integer> oddNumbers = new HashMap<>();
    private List<Character> romanNumbers = new ArrayList<>();

    public Converter() {
        this.setNumbers();
    }

    private void setNumbers() {
        romanNumbers.add('M');
        romanNumbers.add('D');
        romanNumbers.add('C');
        romanNumbers.add('L');
        romanNumbers.add('X');
        romanNumbers.add('V');
        romanNumbers.add('I');
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        oddNumbers.put("IV", 4);
        oddNumbers.put("XL", 40);
        oddNumbers.put("CD", 400);
        oddNumbers.put("IX", 9);
        oddNumbers.put("XC", 90);
        oddNumbers.put("CM", 900);

    }

    /**
     * Converts Roman number (String) to Integer
     *
     * @param number string
     * @return converted string to int
     */
    public int romanToInt(String number) {
        char[] roman = number.toCharArray();
        int result = 0;
        char tmp;
        char key;
        int x = 0;
        for (int i = 0; i < romanNumbers.size(); i++) {
            if (x < roman.length) {
                key = romanNumbers.get(i);
                tmp = roman[x];
                if (tmp == key) {
                    result += map.get(key);
                    i--;
                    x++;
                } else if (i > 0 && roman.length - x > 1) {
                    String concat = String.copyValueOf(roman, x, 2);
                    if (oddNumbers.containsKey(concat)) {
                        result += oddNumbers.get(concat);
                        x = x + 2;
                    }
                }
            } else {
                break;
            }
        }
        return result;
    }
}
