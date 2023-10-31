# -- coding: utf-8 --
def code(n):
    a=0
    b=1
    for i in range(1,n+1):
        b *= i
        a += b
    return b
n=int(input())
r=code(n)
print(r)
