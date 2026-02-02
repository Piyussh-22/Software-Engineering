package strings;

public class _10_validAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            arr[index]++;
        }

        for (char c : t.toCharArray()) {
            int index = c - 'a';
            arr[index]--;
        }

        for (int k : arr) {
            if (k != 0) {
                return false;
            }
        }

        return true;
    }
}
