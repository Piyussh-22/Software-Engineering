package arrays;

public class sumOfArray {
    public static void main(String[] args) {
        System.out.print(sum(new int[] {}));
    }
    static int sum(int[] arr){
        if(arr == null) return 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }
}
