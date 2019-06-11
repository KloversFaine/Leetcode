class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        nums_hash={}
        nums_len = len(nums)
        for i in range(nums_len):
            diff = target - nums[i]
            if diff in nums_hash:
                return [nums_hash[diff],i]
            nums_hash[nums[i]]=i
        return []
