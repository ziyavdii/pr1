#-- coding: utf-8 --
def code(x):
    if((x%4==0)and not(x%100==0))or(x%400==0):
        print("Високосный")
    else:
        print("Обычный")
x=int(input())
r=code(x)
print(r)
