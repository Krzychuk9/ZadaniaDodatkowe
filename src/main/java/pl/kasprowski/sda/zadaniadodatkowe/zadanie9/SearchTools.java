package pl.kasprowski.sda.zadaniadodatkowe.zadanie9;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SearchTools {
    private String hardDrive = "C:\\";
    private String fileName;
    private List<String> results;

    /**
     * Searches hard drive (default C) for param txt file and display result in console, if file not found it displays "File not found!".
     * To change default hard drive (C) use setHardDrive method
     *
     * @param fileName    file name/part of file name being searched
     * @param exactSearch true if you want to find exactly this file, false if you want to find files matches to pattern *fileName*.txt
     */
    public void searchFileInHardDrive(String fileName, boolean exactSearch) {
        results = new ArrayList<>();
        this.fileName = fileName;
        this.search(hardDrive, exactSearch);
        this.print();
    }

    /**
     * Searches destination and sub directories for param txt file and display result in console, if file not found it displays "File not found!"
     *
     * @param desc        path to directory where you want to start
     * @param fileName    file name/part of file name being searched
     * @param exactSearch true if you want to find exactly this file, false if you want to find files matches to pattern *fileName*.txt
     */
    public void searchFileInDirectory(String desc, String fileName, boolean exactSearch) {
        results = new ArrayList<>();
        this.fileName = fileName;
        this.search(desc, exactSearch);
        this.print();
    }

    /**
     * Searches destination and sub directories for param txt file. Private method used in searchFileInDirectory and searchFileInHardDrive.
     *
     * @param desc        path to directory where you want to start
     * @param exactSearch true if you want to find exactly this file, false if you want to find files matches to pattern *fileName*.txt
     */
    private void search(String desc, boolean exactSearch) {
        File file = new File(desc);
        File[] files = file.listFiles(); //ta metoda może przyjąc parametr FilenameFilter.
        if (files != null) {//w tym miejscu następuje sprawdzenie czy desc jest katalogiem ;) (javadoc)
            for (File f : files) {
                if (f.isDirectory()) {
                    this.search(f.getAbsolutePath(), exactSearch);
                } else if (exactSearch) {
                    if (this.fileName.equals(f.getName())) {
                        results.add(f.getAbsolutePath());
                    }
                } else {
                    if (this.isValid(f.getName())) {
                        results.add(f.getAbsolutePath());
                    }
                }
            }
        }
        else {
            throw new RuntimeException("Wrong path!");
        }
    }

    /**
     * Checks if part of file name being searched matches found file name (ignore case)
     *
     * @param foundFile name of found file
     * @return true if fileName matches pattern
     */
    private boolean isValid(String foundFile) {
        //todo: lepszym sposobem na budowanie ciągów znaków jest StringBuilder. Wynika to z natury klasy String.
        StringBuilder regex = new StringBuilder(".*");
        regex.append(this.fileName.toLowerCase());
        regex.append(".*\\.txt");
        if (Pattern.matches(regex.toString(), foundFile.toLowerCase())) {
            return true;
        }
        return false;
    }

    /**
     * SET default hard drive (by default: C)
     *
     * @param hardDrive string - hard drive's name
     */
    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive + ":\\";
    }

    /**
     * Prints results in console
     *
     * **************************************************************************************************************
     * todo: sposób ok.
     * Niemniej jednak jeśli piszesz klasy narzędziowe, to weź pod uwagę, że one
     * prawdopodobnie będą miały metody wołane z innych klas, które niekoniecznie będą coś wyświetlać na konsoli.
     * każda z metod powinna zwracać coś sensownego (listę lub pojedynczy objekt w zależnośco co się dzieje)
     * Wiem, że może to wyglądać na takie czepianie się, dlatego tylko miej to na uwadze ;)
     */
    private void print() {
        if (results.size() > 0) {
            System.out.println("Search for " + this.fileName + ", results: ");
            this.results.stream().forEach(System.out::println);
        } else {
            System.out.println("File not found!");
        }
    }
}
