import java.util.*;
public class MyString {
    public static void main(String[] args) {
        String sentence = "    foo    bar";
        System.out.println(Arrays.toString(sentence.trim().split("\\s+")));

        String s = "    ";
        s.trim();
        System.out.println(s);
    }
}
