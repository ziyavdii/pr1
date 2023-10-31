#-- coding: utf-8 --
def num(a,b):
    for num in range(a,b-1,-1):
        if num % 2 != 0:
            print(num)
a=int(input())
b=int(input())
r=num(a,b)
print(r)

