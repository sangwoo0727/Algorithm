from typing import *


class Solution:
    def longestPalindrome(self, s: str) -> str:
        dp: List[List[bool]] = [[False] * len(s) for _ in range(len(s))]
        answer: str = s[0]

        for idx in reversed(range(len(s))):
            for jdx in range(idx, len(s)):
                dp[idx][jdx] = s[idx] == s[jdx] and (jdx - idx <= 2 or dp[idx + 1][jdx - 1])
                if dp[idx][jdx] and jdx - idx >= len(answer):
                    answer = s[idx:jdx + 1]

        return answer
