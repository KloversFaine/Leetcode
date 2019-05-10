class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2){
            return s;
        }
        String result = "";
        int sub = 2 * numRows - 2;
        for (int i = 0;i < numRows; i++){
            for(int j = i;j < s.length(); j += sub){
                result += s.charAt(j); 
                int tmp = j + 2*(numRows - (i+1));
                if(i != 0 && i != numRows - 1 && tmp < s.length()){
                    result += s.charAt(tmp);
                }
            }
        }
        return result;
    }
}
