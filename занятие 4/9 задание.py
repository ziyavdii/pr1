# -- coding: utf-8 --
def code(n):
    a=0
    b=1
    c=0
    for i in range(n):
        a,b=b+a,b
        c += a
    return c
n=int(input())
r=code(n)
print(r)
