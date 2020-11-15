from typing import *


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not len(strs):
            return ''
        index = 0
        for i in range(0, len(strs[0])):
            flg = False
            for s in strs:
                if strs[0][0:i + 1] != s[0:i + 1]:
                    flg = True
                    break
            if flg:
                return strs[0][0:i]
            else:
                index = i
        return strs[0][0:index + 1]
