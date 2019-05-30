<--- Solution 1 --->
/*
 * ArrayList
 */
class Solution {
    public int maxArea(int[] height) {
        ArrayList<Integer> point = new ArrayList<Integer>();
        for(int i=0;i<height.length;i++){
            point.add(height[i]);
        }
        int max_result = 0;
		for(int i=0;i<point.size();i++) {
			for(int j=point.size()-1;i<j;j--) {
				max_result = Math.max(max_result, (j-i)*Math.min(point.get(i), point.get(j)));
			}
		}
        return max_result;
    }
}

<--- Solution 2 --->
/*
 * Vector
 */
class Solution {
    public int maxArea(int[] height) {
        int max_result = 0;
		for(int i=0;i<height.length;i++) {
			for(int j=height.length-1;i<j;j--) {
				max_result = Math.max(max_result, (j-i)*Math.min(height[i], height[j]));
			}
		}
        return max_result;
    }
}
