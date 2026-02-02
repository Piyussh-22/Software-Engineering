package strings;

public class _07_columnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("HJS"));
    }
    static int titleToNumber(String columnTitle){
        char[] arr = columnTitle.toCharArray();
        int number = 0;
        for(int i = 0 ; i < arr.length ; i++){
            int alphNum = arr[i] - 'A' + 1 ;
            number = (number * 26) + alphNum;
        }
        return number;
    }
}
