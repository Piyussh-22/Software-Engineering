class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();
        for(String s : strs){
            int length = s.length();
            encodedStr.append(length).append("#").append(s);
        }
        return encodedStr.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedList = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            StringBuilder charLen = new StringBuilder();
            while(str.charAt(i) != '#'){
                charLen.append(str.charAt(i));
                i++;
            }
            int length = Integer.parseInt(charLen.toString());
            decodedList.add(str.substring( (i+1), (i+1)+length));
            i = i + 1 + length;
        }
        return decodedList;
    }
}
