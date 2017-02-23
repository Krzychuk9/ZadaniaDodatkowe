package pl.kasprowski.sda.zadaniadodatkowe.zadanie6;

import java.util.HashMap;
import java.util.Map;

public class Numbers {
    private Map<Integer, String[]> numbers;

    public Numbers() {
        this.setNumbers();
    }

    /**
     * Fills map with string representation of numbers/prefix ect.
     */
    private void setNumbers() {
        String[] digits = {"zero", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};
        String[] digits2 = {"zero", "jede", "dwa", "trzy", "czter", "pięt", "szes", "siedem", "osiem", "dziewięt"};

        numbers = new HashMap<>();
        numbers.put(1, digits);
        numbers.put(2, new String[]{"dziesięć", "jedenaście", "naście"});
        numbers.put(3, new String[]{"dzieścia", "dzieści", "dziesiąt"});
        numbers.put(4, new String[]{"sto", "dwieście", "sta", "set"});
        numbers.put(5, new String[]{"tysiąc", " tysiące", " tysięcy"});
        numbers.put(6, digits2);

    }

    /**
     * Transform int to String
     *
     * @param number int to transform
     * @return string representation of param
     */
    public String getNumber(Integer number) {
        int tmp;
        StringBuffer sb = new StringBuffer();
        if (number > 1000000) {
            return "Out of range!";
        }
        do {
            if (number == 1000000) {
                sb.append("Milion!");
                break;
            } else if ((tmp = number / 100000) > 0) {
                if (tmp == 1) {
                    sb.append(numbers.get(4)[0] + " ");
                } else if (tmp == 2) {
                    sb.append(numbers.get(4)[1] + " ");
                } else if (tmp < 5) {
                    sb.append(numbers.get(1)[tmp] + numbers.get(4)[2] + " ");
                } else {
                    sb.append(numbers.get(1)[tmp] + numbers.get(4)[3] + " ");
                }
                number = number % 100000;
            } else if ((tmp = number / 10000) > 1) {
                if (tmp == 2) {
                    sb.append(numbers.get(1)[tmp] + numbers.get(3)[0] + " ");
                } else if (tmp < 5) {
                    sb.append(numbers.get(6)[tmp] + numbers.get(3)[1] + " ");
                } else {
                    sb.append(numbers.get(1)[tmp] + numbers.get(3)[2] + " ");
                }
                if ((tmp = (number / 1000) % 10) != 0) {
                    sb.append(numbers.get(1)[tmp] + numbers.get(5)[1] + " ");
                } else {
                    sb.append(numbers.get(5)[2] + " ");
                }

                number = number % 1000;
            } else if (number / 10000 > 0) {
                tmp = number / 1000;
                if (tmp == 10) {
                    sb.append(numbers.get(2)[0] + numbers.get(5)[2] + " ");
                } else {
                    sb.append(numbers.get(6)[tmp - 10] + numbers.get(2)[2] + numbers.get(5)[2] + " ");
                }
                number = number % 1000;
            } else if ((tmp = number / 1000) > 0) {
                number = number % 1000;
                if (tmp == 1) {
                    sb.append(numbers.get(5)[0] + " ");
                } else if (tmp < 5) {
                    sb.append(numbers.get(1)[tmp] + numbers.get(5)[1] + " ");
                } else {
                    sb.append(numbers.get(1)[tmp] + numbers.get(5)[2] + " ");
                }
            } else if ((tmp = number / 100) > 0) {
                number = number % 100;
                if (tmp == 1) {
                    sb.append(numbers.get(4)[0] + " ");
                } else if (tmp == 2) {
                    sb.append(numbers.get(4)[1] + " ");
                } else if (tmp < 5) {
                    sb.append(numbers.get(1)[tmp] + numbers.get(4)[2] + " ");
                } else {
                    sb.append(numbers.get(1)[tmp] + numbers.get(4)[3] + " ");
                }
            } else if ((tmp = number / 10) > 1) {
                number = number % 10;
                if (tmp == 2) {
                    sb.append(numbers.get(1)[tmp] + numbers.get(3)[0] + " ");
                } else if (tmp < 5) {
                    sb.append(numbers.get(6)[tmp] + numbers.get(3)[1] + " ");
                } else {
                    sb.append(numbers.get(1)[tmp] + numbers.get(3)[2] + " ");
                }
            } else if (number / 10 > 0) {
                if (number == 10) {
                    sb.append(numbers.get(2)[0]);
                } else {
                    number = number % 10;
                    sb.append(numbers.get(6)[number] + numbers.get(2)[2]);
                }
                break;
            } else if (number >= 0) {
                sb.append(numbers.get(1)[number]);
                number = 0;
            }
        } while (number > 0);
        return sb.toString();

    }

}
