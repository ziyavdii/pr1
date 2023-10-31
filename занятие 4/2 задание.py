#-- coding: utf-8 --
def code(a,b):
    if a<=b:
        for i in range(a,b+1):
            print(i)
    else:
        for i in range(a,b-1,-1):
            print(i)
a=int(input())
b=int(input())
r=code(a,b)
print(r)
