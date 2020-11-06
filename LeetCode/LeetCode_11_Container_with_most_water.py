from typing import *


class Solution:
    def maxArea(self, height: List[int]) -> int:
        l_idx, r_idx = 0, len(height) - 1
        max_area = 0
        while l_idx < r_idx:
            max_area = max(max_area, (r_idx - l_idx) * min(height[l_idx], height[r_idx]))
            if height[l_idx] < height[r_idx]:
                l_idx += 1
            else:
                r_idx -= 1
        return max_area
