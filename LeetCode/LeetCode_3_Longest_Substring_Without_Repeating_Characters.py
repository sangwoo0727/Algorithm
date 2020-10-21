class Solution:
    def length_of_longest_substring(self, s: str) -> int:
        return binary_search(len(s), s)


def binary_search(size: int, s: str) -> int:
    left: int = 0
    right: int = size
    answer: int = 0
    while left <= right:
        middle = (left + right) // 2
        if check(middle, s):
            answer = middle
            left = middle + 1
        else:
            right = middle - 1
    return answer


def check(length: int, s: str) -> bool:
    store: dict = {}
    left: int = 0
    right: int = length - 1
    for idx in range(length):
        if s[idx] in store:
            store[s[idx]] += 1
        else:
            store[s[idx]] = 1
    if len(store) == length:
        return True
    while right + 1 < len(s):
        if store[s[left]] == 1:
            del store[s[left]]
        else:
            store[s[left]] -= 1
        if s[right + 1] in store:
            store[s[right + 1]] += 1
        else:
            store[s[right + 1]] = 1
        left += 1
        right += 1
        if len(store) == length:
            return True
    return False
