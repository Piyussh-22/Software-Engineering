class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for(char c : s.toCharArray()){
            if(c == 'P'){
                late = 0;
            }else if(c == 'A'){
                late = 0;
                absent++;
                if(absent > 1){
                    return false;
                }
            }else if(c == 'L'){
                late++;
                if(late >= 3){
                    return false;
                }
            }
        }
        return true;
    }
}