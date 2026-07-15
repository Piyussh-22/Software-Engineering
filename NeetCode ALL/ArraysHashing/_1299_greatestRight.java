// m1. time n2 space n
class Solution {
    public int[] replaceElements(int[] arr) {
        int[] answer = new int[arr.length];
        for(int i = 0 ; i < answer.length-1 ; i++){
            int greatest = 0;
            for(int j = i+1 ; j < answer.length ; j++){
                if(arr[j] > greatest){
                    greatest = arr[j];
                }
            }
            answer[i] = greatest;
        }
        answer[arr.length-1] = -1;
        return answer;
    }
}

//m2 time n2 space n 
class Solution2 {
    public int[] replaceElements(int[] arr) {
        int[] answer = new int[arr.length];
        int greatest = Integer.MIN_VALUE;
        for(int i = 0 ; i < answer.length-1 ; i++){
            if(i == 0 || arr[i] >= greatest){
                greatest = Integer.MIN_VALUE;
                for(int j = i+1 ; j < answer.length ; j++){
                    if(arr[j] > greatest){
                        greatest = arr[j];
                    }
                }    
            }
            answer[i] = greatest;
        }
        answer[arr.length-1] = -1;
        return answer;
    }
}

// m3 time n space n 
class Solution3 {
    public int[] replaceElements(int[] arr) {
        int len = arr.length ;

        int[] answer = new int[len];
        answer[len-1] = -1;

        int greatest = arr[len-1];
        for(int i = len-2 ; i >= 0 ; i--){
            if(greatest < arr[i+1]){
                greatest = arr[i+1];
            }
            answer[i] = greatest;
        }
        return answer;
    }
}

// m4 time n and space n.
class Solution4 {
    public int[] replaceElements(int[] arr) {
        int len = arr.length ;

        int greatest = arr[len-1];
        int justRightSide = arr[len-1];
        arr[len-1] = -1;

        for(int i = len-2 ; i >= 0 ; i--){
            if(greatest < justRightSide){
                greatest = justRightSide;
            }
            justRightSide = arr[i];
            arr[i] = greatest;
        }
        return arr;
    }
}