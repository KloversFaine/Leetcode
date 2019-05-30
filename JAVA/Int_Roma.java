class Solution {
    public String intToRoman(int num) {
        int res = 0;
		StringBuffer stringBuffer = new StringBuffer();
		res = num/1000; num %= 1000;
		for(int i=0;i<res;i++) {
			stringBuffer.append("M");
		}
		res = num/100; num %= 100;
		stringBuffer.append(convert(res,"C","D","M"));//百位数
		res = num/10;  num %= 10;
		stringBuffer.append(convert(res,"X","L","C"));//十位数
		stringBuffer.append(convert(num,"I","V","X"));//个位数
		return stringBuffer.toString();
    }
    public String convert(int result,String s1,String s2,String s3) {
		switch(result) {
			case 0:
				return "";
			case 1:	
				return s1;
			case 2:
				return s1+s1;
			case 3:	
				return s1+s1+s1;
			case 4:
				return s1+s2;
			case 5:
				return s2;
			case 6:	
				return s2+s1;
			case 7:
				return s2+s1+s1;
			case 8:	
				return s2+s1+s1+s1;
			case 9:
				return s1+s3;
		}
		return null;
	}
}
