class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length==0)
            return result;
        String s = strs[0];
        int n = strs.length;
        for(int j=1;j<n;j++){
            if(!(strs[j].length()>s.length())){
               s=strs[j]; 
            }      
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i) != s.charAt(i)){
                    return result;
                }
            }
            result += s.charAt(i);
        }
        return result;
    }
}
