#-- coding: utf-8 --
def num(a,b,c,d):
    if(a+b+c+d)%2==0:
        print('YES')
    else:
        print('NO')
a=int(input())
b=int(input())
c=int(input())
d=int(input())
r=num(a,b,c,d)
print(r)
