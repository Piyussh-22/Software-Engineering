class Solution {
    public int minOperations(String[] logs) {
        int steps = 0;
        for(String s : logs){
            if(s.endsWith("../")){
                if(steps > 0){
                    steps--;
                }
            }else if(s.endsWith("./")){
                continue;
            }else{
                steps++;
            }
        }
        return steps;
    }
}