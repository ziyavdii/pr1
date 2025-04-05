#-- coding: utf-8 --
def num(a,b,c):
    if a==b==c :
        print(3)
    elif a==b or a==c or b==c :
        print(2)
    else:
        print(0)
a=int(input())
b=int(input())
c=int(input())
r=num(a,b,c)
print(r)
