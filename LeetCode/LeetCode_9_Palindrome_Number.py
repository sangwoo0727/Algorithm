import math

class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        elif x == 0:
            return True
        tmp_num, result, idx = x, 0, pow(10, int(math.log10(x)))
        while tmp_num > 0:
            result += ((tmp_num % 10) * idx)
            tmp_num //= 10
            idx //= 10
        return result == x
