class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) <= 1:
            return s

        dp: list = [[0] * len(s) for _ in range(len(s))]
        answer: str = s[0]

        for idx in range(len(s)):
            dp[idx][idx] = 1

        for idx in range(len(s) - 1):
            if s[idx] == s[idx + 1]:
                dp[idx][idx + 1] = 1
                answer = s[idx:idx + 2]
            else:
                dp[idx][idx + 1] = 0

        for length in range(3, len(s) + 1):
            for idx in range(len(s) - length + 1):
                right_idx: int = idx + length - 1
                if s[idx] == s[right_idx] and dp[idx + 1][right_idx - 1] == 1:
                    dp[idx][right_idx] = 1
                    if len(answer) < length:
                        answer = s[idx:right_idx + 1]
                else:
                    dp[idx][right_idx] = 0

        return answer
