import sys

n = int(sys.stdin.readline().rstrip())
li = [int(n) for n in sys.stdin.readline().split()]

print(max(li)-min(li))

