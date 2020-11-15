from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        answer = []
        nums.sort()
        for idx, num in enumerate(nums):
            if idx == len(nums) - 2:
                break
            if idx != 0 and num == nums[idx - 1]:
                continue
            left, right = idx + 1, len(nums) - 1
            while left < right:
                sum = num + nums[left] + nums[right]
                if sum == 0:
                    answer.append([num, nums[left], nums[right]])
                    while left < len(nums) - 1 and nums[left] == nums[left + 1]:
                        left += 1
                    while right > idx and nums[right] == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1
                elif sum < 0:
                    left += 1
                else:
                    right -= 1
        return answer
