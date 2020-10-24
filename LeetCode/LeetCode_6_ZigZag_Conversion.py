class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        store: dict = {}
        row: int = 0
        flag: bool = True
        for alp in s:
            if row not in store:
                store[row] = ''
            store[row] += alp
            if flag:
                if row + 1 == numRows:
                    flag = False
                    row -= 1
                else:
                    row += 1
            else:
                if row == 0:
                    flag = True
                    row += 1
                else:
                    row -= 1
        answer: str = ''
        for row in range(numRows):
            if row in store:
                answer += store[row]
        return answer

