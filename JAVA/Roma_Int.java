/*
 * Lacurs code
 *
 *
 */
 
class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)) {
				case'I':
					result += 1;
					break;
				case'V':
					result += 5;
					break;
				case'X':
					result += 10;
					break;
				case'L':
					result += 50;
					break;
				case'C':
					result += 100;
					break;
				case'D':
					result += 500;
					break;
				case'M':
					result += 1000;
					break;
			}
			if(i!=0) {
				// IV IX
				if(s.charAt(i-1)=='I'&&(s.charAt(i)=='V'||s.charAt(i)=='X')) {
					result -= 1*2;
				}
				// XL XC
				if(s.charAt(i-1)=='X'&&(s.charAt(i)=='L'||s.charAt(i)=='C')) {
					result -= 10*2;
				}
				// CD CM
				if(s.charAt(i-1)=='C'&&(s.charAt(i)=='D'||s.charAt(i)=='M')) {
					result -= 100*2;
				}
			}
        }
        return result;
    }
}
