class Solution {
    public int myAtoi(String str) {
        String s = str;
        // null or empty string
        if(s == null || s.length() == 0){
            return 0;
        }
        //去除前后空格
        s = s.trim();
        //二次验证
        if(s == null || s.length() == 0){
          return 0;
        }
        boolean sign =true;
        int i = 0;
        char signChar = s.charAt(i);
        if(signChar == '+'){
            i++;
        }else if(signChar == '-'){
            sign = false;
            i++;
            //System.out.println(s);
        }
        
        //计算结果值
        long temp = 0;
        for(;i<s.length();i++){
            int digit = s.charAt(i) - '0';
            if(digit < 0 || digit > 9){
                break;
            }
            if(sign){
                temp = temp*10 + digit;
                if(temp > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }else{
                temp = temp*10 - digit;
                if(temp < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }   
        }
        return (int) temp;
    }
}
