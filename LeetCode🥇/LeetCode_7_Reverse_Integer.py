class Solution:
    def reverse(self, x: int) -> int:
        if x < 0:
            x *= -1
            s: str = '-' + ''.join(reversed(str(x)))
        else:
            s: str = ''.join(reversed(str(x)))

        if int(s) > 2 ** 31 or int(s) < (-2) ** 31:
            return 0
        return int(s)
