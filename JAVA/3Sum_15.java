## time limit exceeded

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> templist = null; 
        if (nums == null){
            return null;
        }
        if (nums.length < 3){
            return list;
        }
        
        for (int i = 0; i < nums.length ; i++){
            if (nums[i] > 0){
                break;
            }
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int result = nums[i] + nums[j] + nums[k];
                if(result == 0){
                    templist = new ArrayList<Integer>();
                    templist.add (nums[i]);
                    templist.add (nums[j]);
                    templist.add (nums[k]);
                    list.add(templist);
                    while (j<k && nums[j] == nums[j+1]){
                        j++;
                    }
                    while (j<k && nums[k] == nums[k-1]){
                        k--;
                    }
                }else if (result < 0){
                    j++;
                }else{
                    k--;
                }
            }
            
        } 
        return list;
    }
}
