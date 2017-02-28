package pl.kasprowski.sda.zadaniadodatkowe.zadanie9;

public class Main {
    public static void main(String[] args) {
        SearchTools st = new SearchTools();
        st.searchFileInDirectory("C:\\Users\\Admin\\Downloads", "CSS.txt", true);
        st.searchFileInDirectory("C:\\Users\\Admin\\Downloads", "cS", false);
        st.setHardDrive("F");
        st.searchFileInHardDrive("CSS.txt", true);
    }
}
