# -- coding: utf-8 --
def code(n):
    s = 0
    for i in range(1,n+1):
        s += i**3
    return s  
n=int(input())
r=code(n)
print(r)
