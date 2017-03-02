package pl.kasprowski.sda.zadaniadodatkowe.zadanie9;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SearchTools st = new SearchTools();
        List<String> list1 = st.searchFileInDirectory("C:\\Users\\Admin\\Downloads", "CSS.txt", true);
        List<String> list2 = st.searchFileInDirectory("C:\\Users\\Admin\\Downloads", "cS", false);

        list1.forEach(System.out::println);
        list2.forEach(System.out::println);

        st.setHardDrive("F");
        List<String> list3 = st.searchFileInHardDrive("CSS.txt", true);
        list3.forEach(System.out::println);

        List<String> list4 = st.searchInFileInDirectory("C:\\Users\\Admin\\Downloads", "java");
        list4.forEach(System.out::println);
    }
}
