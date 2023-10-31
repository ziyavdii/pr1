#-- coding: utf-8 --
def num(a,b,c):
    if a<b<c:
        print(a)
    elif b<a<c:
        print(b)
    else:
        print(c)
a=int(input())
b=int(input())
c=int(input())
r=num(a,b,c)
print(r)
