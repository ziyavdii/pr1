# -- coding: utf-8 --
def code(n):
    for i in range(1,n+1):
        for j in range(1,i+1):
            print(j,sep='',end='')
        print()
n=int(input())
r=code(n)
print(r)
