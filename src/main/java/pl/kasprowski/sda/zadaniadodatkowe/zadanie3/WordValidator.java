package pl.kasprowski.sda.zadaniadodatkowe.zadanie3;

public class WordValidator {

    /**
     * Calculates Levenshtein distance (string metric for measuring the difference between two sequences), simply impl (takes into account only changing chars)
     *
     * @param s1 first string
     * @param s2 second string
     * @return int - Levenshtein distance
     */
    public int getLevenshteinSimply(String s1, String s2) {
        int distance = 0;

        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        for (int i = 0; i < array1.length && i < array2.length; i++) {
            if (array1[i] != array2[i]) {
                distance++;
            }
        }
        return distance;
    }

    /**
     * Calculates Levenshtein distance (string metric for measuring the difference between two sequences), complex impl
     *
     * @param s1 first string
     * @param s2 second string
     * @return Levenshtein distance
     */
    public int getLevenshtein(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] array = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            array[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            array[0][i] = i;
        }
        int cost;
        for (int i = 1; i < array.length; i++) {
            char tmp = s1.charAt(i - 1);
            for (int j = 1; j < array[i].length; j++) {
                if (tmp != s2.charAt(j - 1)) {
                    cost = 1;
                } else {
                    cost = 0;
                }
                int v1 = array[i - 1][j] + 1;
                int v2 = array[i][j - 1] + 1;
                int v3 = array[i - 1][j - 1] + cost;
                array[i][j] = this.min(v1, v2, v3);
            }
        }
        return array[n][m];
    }

    /**
     * return minimum of three ints
     *
     * @param i first int
     * @param j socond int
     * @param k third int
     * @return int
     */
    private int min(int i, int j, int k) {
        int min = i;
        if (min > j) {
            min = j;
            if (min > k) {
                min = k;
                return min;
            }
        } else if (min > k) {
            min = k;
        }
        return min;
    }
}
