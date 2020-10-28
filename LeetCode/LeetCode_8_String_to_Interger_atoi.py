class Solution:
    def myAtoi(self, s: str) -> int:
        INT_MAX = pow(2, 31) - 1
        INT_MIN = -pow(2, 31)

        num = ''
        for idx, c in enumerate(s):
            if c == ' ':
                continue
            elif c.isalpha() or c == '.':
                break
            elif c.isdigit():
                num += c
                if idx + 1 < len(s) and not s[idx + 1].isdigit():
                    break
            elif c == '-' or c == '+':
                if idx + 1 < len(s) and s[idx + 1].isdigit():
                    num += c
                else:
                    break
        num = int(num) if num else 0
        num = INT_MAX if num > INT_MAX else num
        num = INT_MIN if num < INT_MIN else num
        return num
