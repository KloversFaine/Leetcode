class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else if(x==0){
            return true;
        }   
        int res=0, tmp=x;
        while(tmp>0){
            res = res*10 + tmp%10;
            tmp = tmp/10;
        }
        //System.out.println(res);
        if(res == x){
            return true;
        }else{
            return false;
        }
    }
}
