package strings;

public class _17_countDiffChar {
    public static void main(String[] args) {

        String s = "geeks 4=-/.'for @piraj221";

        int vowels = 0, consonants = 0, digit = 0, special = 0;

        for(char c : s.toLowerCase().toCharArray()){

            if(Character.isLetter(c)){

                if("aeiou".indexOf(c) != -1){
                    vowels++;
                }else{
                    consonants++;
                }

            }else if(Character.isDigit(c)){
                digit++;
            }else{
                special++;
            }
        }

        System.out.printf(
                "Vowels: %d\nConsonants: %d\nDigits: %d\nSpecial: %d",
                vowels, consonants, digit, special
        );
    }
}
