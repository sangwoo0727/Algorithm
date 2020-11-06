from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        answer_list = []
        answer_set = set()
        nums.sort()
        for idx, num in enumerate(nums):
            if idx == len(nums) - 2:
                break
            left, right = idx + 1, len(nums) - 1
            while left < right:
                sum = num + nums[left] + nums[right]
                if sum == 0:
                    answer_set.add((num, nums[left], nums[right]))
                    left += 1
                    right -= 1
                elif sum < 0:
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    left += 1
                else:
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    right -= 1
        for t in answer_set:
            answer_list.append(list(t))
        return answer_list
