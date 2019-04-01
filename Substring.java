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
// solution 2 
// a faster version considering the diff of a 'Char'
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0 , right = -1 , result = 0;
        int n = s.length();
        int[] substring = new int [256];
        while(left < n){
            if (right + 1 < n && substring[s.charAt(right + 1)] == 0){
                right++;
                substring[s.charAt(right)] = 1;
            }else{
                substring[s.charAt(left)] = 0;
                left++;
            }
            result = Math.max(result , right - left + 1);
        }
        return result;
    }
}
