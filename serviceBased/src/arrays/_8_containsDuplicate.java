package arrays;

import java.util.HashSet;
import java.util.Set;

public class _8_containsDuplicate {
    public static void main(String[] args){
        int[] array = {1,2,3,4};
        int[] array2 = {1,2,3,3};
        boolean ans = cheakDuplicate(array);
        boolean ans2 = cheakDuplicate(array2);
        System.out.println(ans +" "+ ans2);
    }
    static boolean cheakDuplicate(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            if(set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
