import sys

K = int(sys.stdin.readline())
stack = []

for _ in range(K):
    n = int(sys.stdin.readline())
    stack.pop() if n == 0 else stack.append(n)

print(sum(stack))


