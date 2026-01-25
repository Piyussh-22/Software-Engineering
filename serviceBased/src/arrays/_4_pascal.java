package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4_pascal {
    public static void main(String[] args) {
        System.out.print(Arrays.deepToString(pascal(5).toArray()));
    }
    static List<List<Integer>> pascal(int n){
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> currRow = new ArrayList<>();
            // first element always 1
            currRow.add(1);

            //middle element
            for (int j = 1; j < i; j++) {
                int val = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                currRow.add(val);
            }

            //last
            if(i>0){
                currRow.add(1);
            }
            ans.add(currRow);
        }
        return ans;

    }
}
