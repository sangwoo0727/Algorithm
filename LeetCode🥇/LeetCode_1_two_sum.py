from typing import List

class Solution:
    def two_sum(self, nums: List[int], target: int) -> List[int]:
        store = {}
        for idx, num in enumerate(nums):
            if num in store:
                return [store[num], idx]
            store[target - num] = idx
