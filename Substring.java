// solution 1 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        int result = 1;
        for (int i = 0; i < s.length(); i++){
            for (int j = i+1 ; j < s.length(); j++){
                boolean flag = false;
                for (int k = i ; k < j; k++){
                    if(s.charAt(k) == s.charAt(j)){
                        flag = true ;
                        break;
                    }
                }
                if(!flag){
                    result = Math.max(result, j-i+1);
                }else{
                        break;
                }
            }
        }
        return result;    
    }
}
