class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int planted = 0;
        int len = flowerbed.length;
        for(int i = 0 ; i < len ; i++){
            if(i == 0){
                if(len == 1 && flowerbed[i] == 0){
                    planted++;
                    flowerbed[i] = 1;
                }else if(flowerbed[i] == 0 && flowerbed[i+1] == 0){
                    planted++;
                    flowerbed[i] = 1;
                }

            }else if(i == len-1 && flowerbed[i] == 0 && flowerbed[i-1] == 0 ){
                planted++;
                flowerbed[i] = 1;
            }else if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                planted++;
                flowerbed[i] = 1;
            }
        }
        if(planted >= n){
            return true;
        }
        return false;
    }
}

class Solution2 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int planted = 0;
        int len = flowerbed.length;
        for(int i = 0 ; i < len ; i++){
            if(flowerbed[i] == 1){
                continue;
            }
            boolean leftEmpty = (i == 0) || flowerbed[i-1] == 0 ;
            boolean rightEmpty = (i == len-1) || flowerbed[i+1] == 0;

            if(leftEmpty && rightEmpty){
                planted++;
                flowerbed[i] = 1;
                if(planted >= n){
                    return true;
                }
            }
        }
        return planted >= n;
    }
}