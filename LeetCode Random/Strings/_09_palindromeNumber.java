package Strings;

//method 1;
class Solution1 {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int length = ((int) (Math.log10(x) + 1)) - 1;
        int reverseNum = 0;
        int tempX = x;
        while(tempX > 0){
            int temp = tempX % 10;
            reverseNum = reverseNum + (int) (temp * Math.pow(10,length));
            length--;
            tempX = tempX/10;
        }
        if(reverseNum == x){
            return true;
        }
        return false;
    }
}
//method 2
class Solution2 {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String numAsString = String.valueOf(x);

        for(int i = 0 ; i < numAsString.length()/2 ; i++){
            if(numAsString.charAt(i) != numAsString.charAt(numAsString.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}