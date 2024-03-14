package Strings;

// import java.util.Arrays;

public class Anagrams {
    // Without using sort
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        a = a.toLowerCase();
        b = b.toLowerCase();

        int[] charCount = new int[26];

        for (int i = 0; i < a.length(); i++) {
            charCount[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            if (charCount[ch - 'a'] == 0) {
                return false;
            }
            charCount[ch - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    // Using sort func
    // static boolean isAnagram(String a, String b) {
    // if (a.length() != b.length()) {
    // return false;
    // }

    // char[] aChars = a.toCharArray();
    // char[] bChars = b.toCharArray();
    // Arrays.sort(aChars);
    // Arrays.sort(bChars);

    // for (int i = 0; i < aChars.length; i++) {
    // if (aChars[i] != bChars[i]) {
    // return false;
    // }
    // }

    // return true;
    // }

}
