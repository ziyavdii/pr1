# -- coding: utf-8 --
def code(n):
    r=1
    for i in range(1,n+1):
        r *=i
    print(r)
n=int(input())
s=code(n)
print(s)
