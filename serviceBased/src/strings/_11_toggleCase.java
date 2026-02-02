package strings;

public class _11_toggleCase {
    public static void main(String[] args) {
        System.out.println(toggleCase("geeksForgEeks"));
    }
    static String toggleCase(String s){
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for(char c : arr){
            if (c >= 'a' && c <= 'z') {
                sb.append((char)(c - 32));
            }
            else if (c >= 'A' && c <= 'Z') {
                sb.append((char)(c + 32));
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String toggleCase2(String s) {

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            }
            else if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            }
            else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
