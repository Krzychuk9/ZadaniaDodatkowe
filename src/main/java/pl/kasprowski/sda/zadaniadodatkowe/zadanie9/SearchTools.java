package pl.kasprowski.sda.zadaniadodatkowe.zadanie9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SearchTools {
    private String hardDrive = "C:\\";
    private String fileName;
    private String content;
    private List<String> results;
    private static final String EXTENSION = "txt";

    /**
     * Searches hard drive (default C) for param txt file and return result in list of found files paths, if file not found return empty list.
     * To change default hard drive (C) use setHardDrive method
     *
     * @param fileName    file name/part of file name being searched
     * @param exactSearch true if you want to find exactly this file, false if you want to find files matches to pattern *fileName*.txt
     * @return List<String> of found files paths, if file not found return empty list
     */
    public List<String> searchFileInHardDrive(String fileName, boolean exactSearch) {
        results = new ArrayList<>();
        this.fileName = fileName;
        this.search(hardDrive, exactSearch);
        return this.results;
    }

    /**
     * Searches destination and sub directories for param txt file and return result in list of found files paths, if file not found return empty list.
     *
     * @param desc        path to directory where you want to start
     * @param fileName    file name/part of file name being searched
     * @param exactSearch true if you want to find exactly this file, false if you want to find files matches to pattern *fileName*.txt
     * @return List<String> of found files paths, if file not found return empty list
     */
    public List<String> searchFileInDirectory(String desc, String fileName, boolean exactSearch) {
        results = new ArrayList<>();
        this.fileName = fileName;
        this.search(desc, exactSearch);
        return this.results;
    }

    /**
     * Searches destination and sub directories for txt file containing indicated content and return result in list of files paths, if file does not exist return empty list.
     *
     * @param desc    path to directory where you want to start
     * @param content String to find
     * @return List<String> of found files paths, if file does not exist return empty list
     */
    public List<String> searchInFileInDirectory(String desc, String content) {
        results = new ArrayList<>();
        this.content = content;
        this.searchInFile(desc);
        return this.results;
    }

    /**
     * Searches destination and sub directories for txt file. Private method used in searchFileInDirectory and searchFileInHardDrive.
     *
     * @param desc        path to directory where you want to start
     * @param exactSearch true if you want to find exactly this file, false if you want to find files matches to pattern *fileName*.txt
     */
    private void search(String desc, boolean exactSearch) {
        File file = new File(desc);
        File[] files = file.listFiles(f -> f.getName().toLowerCase().endsWith(EXTENSION) || f.isDirectory());
        if (files != null) {
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
        } else {
            throw new RuntimeException("Wrong path!");
        }
    }

    /**
     * Searches destination and sub directories for txt file containing indicated substring. Private method used in searchInFileInDirectory.
     *
     * @param desc path to directory where you want to start
     */
    private void searchInFile(String desc) {
        File file = new File(desc);
        File[] files = file.listFiles(f -> f.getName().toLowerCase().endsWith(EXTENSION) || f.isDirectory());
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    this.searchInFile(f.getAbsolutePath());
                } else {
                    StringBuilder sb = new StringBuilder();
                    String line;
                    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                        while ((line = br.readLine()) != null) {
                            sb.append(line);
                        }
//                        Stream<String> fileStream = Files.lines(Paths.get(f.getAbsolutePath()));
//                        fileStream.forEach(s -> sb.append(s));
//                        fileStream.close();
                        if (sb.indexOf(this.content) != -1) {
                            results.add(f.getAbsolutePath());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
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


}
