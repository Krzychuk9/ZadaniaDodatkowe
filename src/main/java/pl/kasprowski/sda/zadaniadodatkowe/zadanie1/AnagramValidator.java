package pl.kasprowski.sda.zadaniadodatkowe.zadanie1;

import java.util.Arrays;

public class AnagramValidator {

    /**
     * checks if two words are anagrams
     *
     * @param w1 string - first word
     * @param w2 string - second word
     * @return boolean
     */
    public boolean isAnagram(String w1, String w2) {
        if (w1.length() != w2.length()) {
            return false;
        }
        char[] word1 = w1.toCharArray();
        char[] word2 = w2.toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);

        for (int i = 0; i < word1.length; i++) {
            if (word1[i] != word2[i]) {
                return false;
            }
        }
        return true;
    }
}
