class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }else{
            int begin = 0, end = 0, maxlen = 0;   
            boolean [][] flag = new boolean[s.length()][s.length()];
            for (int i = s.length(); i >= 0; i--) {
                for(int j = i; j < s.length(); j++){
                    if(s.charAt(i) == s.charAt(j) && (j-i < 2 || flag [i+1][j-1])){
                        flag[i][j] = true; //判断子回环字符串
                        if (maxlen < j-i+1){
                            maxlen = j-i+1;
                            begin = i;
                            end = j;
                        }
                    }
                }
            }
            return s.substring(begin,end+1); 
        }      
    }
}
//空字符串的substring函数
