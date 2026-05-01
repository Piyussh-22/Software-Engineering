public class Vowel {
    public static void main (String[] args){
        int[] arr = {1,2,2,7,3,1,3,6,2,2};
        int k = 2;
        int n = arr.length;
        int s1 = 0 ;
        for(int i = 0 ; i < n/2 ; i++){
            s1 = s1 + arr[i];
        }
        System.out.println(s1);
        int s2 = 0;
        for(int i = n/2 ; i < n ; i++){
            s2 = s2 + arr[i];
        }
        System.out.println(s2);
        System.out.println(Math.abs(s1 - s2) > k);
    }
}
