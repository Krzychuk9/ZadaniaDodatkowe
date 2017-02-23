package pl.kasprowski.sda.zadaniadodatkowe.zadanie5;

import java.io.*;
import java.util.Arrays;

public class DataStructure {
    private int[][] array;


    public DataStructure(String path) {
        this.getDataFromFile(path);
    }

    /**
     * Reads graph from file and builds it's array representation
     *
     * @param fileIn path to file
     */
    private void getDataFromFile(String fileIn) {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileIn)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tmp = line.split("\\t+");
                if (array == null) {
                    array = new int[1][tmp.length];
                } else {
                    array = Arrays.copyOf(array, array.length + 1);
                    array[array.length - 1] = new int[tmp.length];
                }
                for (int i = 0; i < tmp.length; i++) {
                    array[array.length - 1][i] = Integer.valueOf(tmp[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int[][] getArray() {
        return array;
    }

    /**
     * prints to console array representation of graph
     */
    public void print() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
