from typing import *


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        answer = []
        nums.sort()
        for idx in range(len(nums) - 3):
            if idx != 0 and nums[idx] == nums[idx - 1]:
                continue
            for jdx in range(idx + 1, len(nums) - 2):
                if jdx != idx + 1 and nums[jdx] == nums[jdx - 1]:
                    continue
                left, right = jdx + 1, len(nums) - 1
                while left < right:
                    sum = nums[idx] + nums[jdx] + nums[left] + nums[right]
                    if sum < target:
                        left += 1
                    elif sum > target:
                        right -= 1
                    else:
                        answer.append([nums[idx], nums[jdx], nums[left], nums[right]])
                        while left < right and nums[left] == nums[left + 1]:
                            left += 1
                        while left < right and nums[right] == nums[right - 1]:
                            right -= 1
                        left += 1
                        right -= 1
        return answer
