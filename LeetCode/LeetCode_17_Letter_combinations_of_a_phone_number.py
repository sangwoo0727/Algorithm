from typing import *


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        output = []
        dic = {'2': ['a', 'b', 'c'],
               '3': ['d', 'e', 'f'],
               '4': ['g', 'h', 'i'],
               '5': ['j', 'k', 'l'],
               '6': ['m', 'n', 'o'],
               '7': ['p', 'q', 'r', 's'],
               '8': ['t', 'u', 'v'],
               '9': ['w', 'x', 'y', 'z']}

        def back_track(atom, left_digits):
            if not len(left_digits):
                nonlocal output
                output.append(atom)
                return

            now_digit = left_digits[0]
            for alp in dic[now_digit]:
                back_track(atom + alp, left_digits[1:])

        if digits:
            back_track('', digits)
        return output
