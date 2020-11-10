from typing import *


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        answer = 0
        dist = 1000000000000000
        nums.sort()
        for idx, num in enumerate(nums):
            if idx == len(nums) - 2:
                break
            left, right = idx + 1, len(nums) - 1
            while left < right:
                sum = num + nums[left] + nums[right]
                abs_num = abs(sum - target)
                if dist > abs_num:
                    answer = sum
                    dist = abs_num
                if sum < target:
                    left += 1
                elif sum > target:
                    right -= 1
                else:
                    return answer
        return answer
