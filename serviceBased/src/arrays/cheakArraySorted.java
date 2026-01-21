package arrays;

public class cheakArraySorted {
    public static void main(String[] args){
        int[] ans = new int[]{2,3,4,6,5,5,6};
        System.out.print(isSorted(ans));
    }
    static boolean isSorted(int[] array){
        if(array == null || array.length <= 1){
            return true;
        }
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }
}
/*Given an array arr[], check if it is sorted
in ascending order or not.
 Equal values are allowed in an array
 and two consecutive equal values are considered sorted.*/