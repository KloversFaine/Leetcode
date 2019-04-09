// solution 1 --> make use of StringBuilder func()
class Solution {
    public int reverse(int x) {
        StringBuilder stringBuilder = new StringBuilder();       
	    if (x < 0){
	    	x = -x;
	    	stringBuilder.append("-");
	    }
	    while (x > 0){
	    	stringBuilder.append(x % 10);
	    	x /= 10;
	    }
	    try{
	    	return Integer.parseInt(stringBuilder.toString());
	    }catch(Exception e){
	    	return 0;
	    }
	}
}
// solution 2 --> a simple thought to solve this problem
class Solution {
    public int reverse(int x) {
        boolean flag = true;
        if(x < 0){
            x = -x;
            flag = false;
        }
        if(x == 0){
            return 0;
        }
        while(x % 10 == 0){
            x = x / 10;
        }
        long result = 0;
        while(x > 0){
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }
        if(flag){
            return (int)result;
        }else{
            return -(int)result;
        }
        
    }
}
