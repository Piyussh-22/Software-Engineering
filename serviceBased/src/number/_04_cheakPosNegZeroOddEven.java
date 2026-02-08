package number;

public class _04_cheakPosNegZeroOddEven {
    public static void main(String[] args) {
        System.out.println(cheakPosNegZeroOddEven(9));
    }
    static String cheakPosNegZeroOddEven(int n){
        if(n > 0){
            if(n%2==0){
                return n + " is Positive Even";
            }else{
                return n + " is Positive Odd";
            }
        } else if (n < 0) {
            return n + " is Negative";
        }else{
            return n + " is Even";
        }
    }
}
