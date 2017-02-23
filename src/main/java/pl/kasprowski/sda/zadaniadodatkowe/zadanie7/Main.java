package pl.kasprowski.sda.zadaniadodatkowe.zadanie7;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        System.out.println(converter.romanToInt("MCCIX")); //1209
        System.out.println(converter.romanToInt("MMCMXLV")); //2945
        System.out.println(converter.romanToInt("MMDCXXXVII")); //2637
    }
}
