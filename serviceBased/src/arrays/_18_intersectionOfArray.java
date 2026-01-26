package arrays;

import java.util.*;
/*When the problem asks for common elements and
uniqueness doesn’t matter about order,
 use a HashSet to track seen elements
 and remove after use.*/
public class _18_intersectionOfArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }
    static int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int k : nums1){
            set.add(k);
        }
        for(int k : nums2){
            if(set.contains(k)){
                list.add(k);
                set.remove(k);
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for(int k : list){
            ans[i++] = k;
        }
        return ans ;
    }
}
